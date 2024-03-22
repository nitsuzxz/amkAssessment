package com.ikhmal.timesheet.DTO;

public class UserSaveDTO {

    private String name;

    public UserSaveDTO(String name) {
        this.name = name;
    }

    public UserSaveDTO() {
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
                "name='" + name + '\'' +
                '}';
    }
}
