package com.ikhmal.timesheet.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="timesheet")

public class Timesheet {

    @Id
    @Column(name = "timesheetID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer timesheetID;

    @Column(name="project", length = 100)
    private String project;

    @Column(name="task",length= 100)
    private String task;
    @Column(name = "userID")
    private Integer userID;

    @Column(name="dateFrom")
    private Date dateFrom;

    @Column(name="dateTo")
    private Date dateTo;

    @Column(name = "statusID")
    private Integer statusID;

    public Timesheet(Integer timesheetID, String project, String task, Integer userID, Date dateFrom, Date dateTo, Integer statusID) {
        this.timesheetID = timesheetID;
        this.project = project;
        this.task = task;
        this.userID = userID;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.statusID = statusID;
    }

    public Timesheet(String project, String task, Integer userID, Date dateFrom, Date dateTo, Integer statusID) {
        this.project = project;
        this.task = task;
        this.userID = userID;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.statusID = statusID;
    }

    public Timesheet() {
    }


    public Integer getTimesheetID() {
        return timesheetID;
    }

    public void setTimesheetID(Integer timesheetID) {
        this.timesheetID = timesheetID;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public Integer getStatusID() {
        return statusID;
    }

    public void setStatusID(Integer statusID) {
        this.statusID = statusID;
    }

    @Override
    public String toString() {
        return "Timesheet{" +
                "timesheetID=" + timesheetID +
                ", project='" + project + '\'' +
                ", task='" + task + '\'' +
                ", userID=" + userID +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                ", statusID=" + statusID +
                '}';
    }
}
