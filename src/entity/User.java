/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author gvt48
 */
public class User {
    private int id, urgencyPeriod;
    private String password, email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUrgencyPeriod() {
        return urgencyPeriod;
    }

    public void setUrgencyPeriod(int urgencyPeriod) {
        this.urgencyPeriod = urgencyPeriod;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
