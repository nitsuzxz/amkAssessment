package com.ikhmal.timesheet.entity;

import jakarta.persistence.*;
@Entity
@Table(name="status")
public class Status {
    @Id
    @Column(name = "statusID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  statusID;

    @Column(name="statusDescription", length = 15)
    private String statusDescription;

    public Status(int statusID, String statusDescription) {
        this.statusID = statusID;
        this.statusDescription = statusDescription;
    }


    public Status() {
    }

    public Status(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public int getStatusID() {
        return statusID;
    }

    public void setStatusID(int statusID) {
        this.statusID = statusID;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    @Override
    public String toString() {
        return "Status{" +
                "statusID=" + statusID +
                ", statusDescription='" + statusDescription + '\'' +
                '}';
    }
}
