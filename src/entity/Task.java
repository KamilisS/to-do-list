/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author gvt48
 */
public class Task implements Comparable<Task> {
    private int id, user_id, category_id, priority, idInList;
    private String name, description, status, catName, algCriteria;
    private Date deadline;
    Integer algCriteriaNumeric;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public int getIdInList() {
        return idInList;
    }

    public void setIdInList(int idInList) {
        this.idInList = idInList;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getAlgCriteria() {
        return algCriteria;
    }

    public void setAlgCriteria(String algCriteria) {
        this.algCriteria = algCriteria;
    }

    public Integer getAlgCriteriaNumeric() {
        return algCriteriaNumeric;
    }

    public void setAlgCriteriaNumeric(Integer algCriteriaNumeric) {
        this.algCriteriaNumeric = algCriteriaNumeric;
    }
    
    public String deadlineToString() {
        return this.deadline.getYear() + "-" + String.format("%02d", this.deadline.getMonth()) + "-" + String.format("%02d", this.deadline.getDate()) +
                " " + String.format("%02d", this.deadline.getHours()) + ":" + String.format("%02d", this.deadline.getMinutes());
    }

    @Override
    public int compareTo(Task o) {
        return this.getDeadline().compareTo(o.getDeadline());
    }
}
