package com.ikhmal.timesheet.DTO;

import jakarta.persistence.Column;

public class UserDTO {

    private int userID;
    private String name;

    public UserDTO(int userID, String name) {
        this.userID = userID;
        this.name = name;
    }

    public UserDTO() {
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
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
        return "UserDTO{" +
                "userID=" + userID +
                ", name='" + name + '\'' +
                '}';
    }
}
