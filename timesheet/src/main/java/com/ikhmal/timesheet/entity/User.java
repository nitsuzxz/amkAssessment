package com.ikhmal.timesheet.entity;

import jakarta.persistence.*;

@Entity
@Table(name="user")
public class User {

    @Id
    @Column(name = "userID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userID;

    @Column(name="name", length = 50)
    private String name;

    public User(Integer userID, String name) {
        this.userID = userID;
        this.name = name;
    }

    public User(String name) {
        this.name = name;
    }

    public User() {
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", name='" + name + '\'' +
                '}';
    }

}
