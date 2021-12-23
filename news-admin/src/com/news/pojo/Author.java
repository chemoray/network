package com.news.pojo;

import java.io.Serializable;
import java.sql.Date;

public class Author implements Serializable{

    private int id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private int newsnumber;
    private Date create_date;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
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
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public int getNewsnumber() {
        return newsnumber;
    }
    public void setNewsnumber(int newsnumber) {
        this.newsnumber = newsnumber;
    }
    public Date getCreate_date() {
        return create_date;
    }
    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }


    @Override
    public String toString() {
        return "AdminUser [id=" + id + ", username=" + username + ", password=" + password + ", " +
                "email=" + email + ",phone=" + phone +"newsnumber=" + newsnumber +"]";
    }

}