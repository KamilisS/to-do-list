package db;

import common.PasswordHash;
import common.Session;
import entity.Category;
import entity.Task;
import entity.User;
import java.sql.*;
import java.util.ArrayList;

public class DatabaseController {
    private Connection con;
    private static final String DB_CON = 
        "jdbc:mysql://localhost:3306/to_do_list";
    private static final String DB_USER = "root";
    private static final String DB_PSW = "";
    
    private void connectToDB() {
        try {
            this.con = DriverManager.getConnection(DB_CON, DB_USER, DB_PSW);
            Statement stmt = this.con.createStatement();
            System.out.println("Successfully logged into database!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private ResultSet getResultSet(String SQL) {
        try {
            PreparedStatement ps = this.con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public DatabaseController() {
        this.connectToDB();
    }
    
    public boolean createUser(String email, String password) {
        String SQL = "INSERT INTO user (email, password) VALUES "
                + "('" + email + "', '" 
                + PasswordHash.hashPassword(password, email) + "')";
        try {
            PreparedStatement ps = this.con.prepareStatement(SQL);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public Session loginUser(String email, String password) {
        Session session = new Session();
        password = PasswordHash.hashPassword(password, email);
        String SQL = "SELECT id FROM user WHERE email = '" + email + "' AND password = '" + password + "'";
        ResultSet rs = this.getResultSet(SQL);
        try {
            while (rs.next()) {
                session.setUserId(rs.getInt("id"));
                break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return session;
    }
    
    public ArrayList<Category> getUserCategories(int userId) {
        ArrayList<Category> cat = new ArrayList<>();
        String SQL = "SELECT * FROM category WHERE user_id = " + userId;
        ResultSet rs = this.getResultSet(SQL);
        try {
            while (rs.next()) {
                Category c = new Category();
                c.setId(rs.getInt("id"));
                c.setUser_id(userId);
                c.setName(rs.getString("name"));
                cat.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cat;
    }
    
    public boolean createTask(Task task) {
        String SQL = "INSERT INTO task (user_id, category_id, name, description, deadline, priority) VALUES ("
                + "'" + task.getUser_id() + "', " + (task.getCategory_id() != 0 ? "'" + task.getCategory_id() + "'" : "NULL") + ", '" + task.getName() + "', "
                + "'" + task.getDescription() + "', '" + task.deadlineToString() + "', '" + task.getPriority() + "')";
        System.out.println(SQL);
        try {
            PreparedStatement ps = this.con.prepareStatement(SQL);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public ArrayList<Task> getUserTasks(int userId) {
        ArrayList<Task> tasks = new ArrayList<>();
        String SQL = "SELECT task.id, task.name, task.category_id, category.name, task.description, task.deadline, task.priority, task.status "
                + "FROM task "
                + "LEFT JOIN category ON task.category_id = category.id "
                + "WHERE task.status = 'new' AND task.user_id = " + userId + " "
                + "GROUP BY task.id, task.name, task.category_id, task.description, task.deadline, task.priority, task.user_id, task.status "
                + "ORDER BY task.created_at DESC";
        ResultSet rs = this.getResultSet(SQL);
        try {
            int i = 0;
            while (rs.next()) {
                Task c = new Task();
                c.setId(rs.getInt("task.id"));
                c.setUser_id(userId);
                c.setName(rs.getString("task.name"));
                c.setDescription(rs.getString("task.description"));
                c.setDeadline(rs.getTimestamp("task.deadline"));
                c.setIdInList(i);
                c.setCategory_id(rs.getInt("task.category_id"));
                c.setCatName(rs.getString("category.name"));
                c.setPriority(rs.getInt("task.priority"));
                c.setStatus(rs.getString("task.status"));
                System.out.println(c.getId());
                System.out.println(c.getPriority());
                tasks.add(c);
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }
    
    public boolean updateTask(Task t) {
        String SQL = "UPDATE task SET category_id = " + (t.getCategory_id() != 0 ? "'" + t.getCategory_id() + "'" : "NULL") + ", name = '" + t.getName() + 
                "', description = '" + t.getDescription() + "', priority = '" + t.getPriority() + "', deadline = '" + t.deadlineToString() + "' "
                + "WHERE id = " + t.getId();
        System.out.println(SQL);
        try {
            PreparedStatement ps = this.con.prepareStatement(SQL);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean deleteTask(Task t) {
        String SQL = "DELETE FROM task WHERE id = " + t.getId();
        try {
            PreparedStatement ps = this.con.prepareStatement(SQL);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean markTaskAsDone(Task t) {
        String SQL = "UPDATE task SET status = 'finished' WHERE id = " + t.getId();
        try {
            PreparedStatement ps = this.con.prepareStatement(SQL);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean markTaskAsUndone(Task t) {
        String SQL = "UPDATE task SET status = 'new' WHERE id = " + t.getId();
        try {
            PreparedStatement ps = this.con.prepareStatement(SQL);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public ArrayList<Task> getUserDoneTasks(int userId) {
        ArrayList<Task> tasks = new ArrayList<>();
        String SQL = "SELECT task.id, task.name, task.category_id, category.name, task.description, task.deadline, task.priority, task.status "
                + "FROM task "
                + "LEFT JOIN category ON task.category_id = category.id "
                + "WHERE task.status = 'finished' AND task.user_id = " + userId + " "
                + "GROUP BY task.id, task.name, task.category_id, task.description, task.deadline, task.priority, task.user_id, task.status "
                + "ORDER BY task.created_at DESC";
        ResultSet rs = this.getResultSet(SQL);
        try {
            int i = 0;
            while (rs.next()) {
                Task c = new Task();
                c.setId(rs.getInt("task.id"));
                c.setUser_id(userId);
                c.setName(rs.getString("task.name"));
                c.setDescription(rs.getString("task.description"));
                c.setDeadline(rs.getTimestamp("task.deadline"));
                c.setIdInList(i);
                c.setCategory_id(rs.getInt("task.category_id"));
                c.setCatName(rs.getString("category.name"));
                c.setPriority(rs.getInt("task.priority"));
                c.setStatus(rs.getString("task.status"));
                System.out.println(c.getId());
                System.out.println(c.getPriority());
                tasks.add(c);
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }
    
    public boolean createCategory(Category c) {
        String SQL = "INSERT INTO category (name, user_id) VALUES ('" + c.getName() + "', " + c.getUser_id() + ")";
        try {
            PreparedStatement ps = this.con.prepareStatement(SQL);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean deleteCategory(Category c) {
        String SQL = "DELETE FROM category WHERE id = " + c.getId();
        try {
            PreparedStatement ps = this.con.prepareStatement(SQL);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean updateCategory(Category c) {
        String SQL = "UPDATE category SET name = '" + c.getName() + "' WHERE id = " + c.getId();
        try {
            PreparedStatement ps = this.con.prepareStatement(SQL);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public User getUser(int userId) {
        String SQL = "SELECT * FROM user WHERE id = " + userId;
        User u = new User();
        ResultSet rs = this.getResultSet(SQL);
        try {
            while(rs.next()) {
                u.setId(userId);
                u.setEmail(rs.getString("email"));
                u.setUrgencyPeriod(rs.getInt("urgency_period"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }
    
    public boolean updateUser(User u) {
        String SQL = "UPDATE user SET email = '" + u.getEmail() + "', password = '" + u.getPassword() + "', urgency_period = "
            + u.getUrgencyPeriod() + " WHERE id = " + u.getId();
        try {
            PreparedStatement ps = this.con.prepareStatement(SQL);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public int checkUserCredentials(String email, String psw) {
        String SQL = "SELECT * FROM user WHERE email = '" + email + "' AND password = '" + PasswordHash.hashPassword(psw, email) + "'";
        ResultSet rs = this.getResultSet(SQL);
        try {
            while(rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public boolean doesUserExist(int userId) {
        String SQL = "SELECT * FROM user WHERE id = " + userId;
        ResultSet rs = this.getResultSet(SQL);
        try {
            while(rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteUser(User u) {
        String SQL = "DELETE FROM user WHERE id = " + u.getId();
        try {
            PreparedStatement ps = this.con.prepareStatement(SQL);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
