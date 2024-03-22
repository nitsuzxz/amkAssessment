package com.ikhmal.timesheet.DTO;

import com.ikhmal.timesheet.entity.Status;
import com.ikhmal.timesheet.entity.User;
import jakarta.persistence.*;

import java.util.Date;

public class TimesheetDTO {

    private Integer timesheetID;
    private String project;
    private String task;
    private Integer  userID;
    private Date dateFrom;
    private Date dateTo;
    private Integer  statusID;

    public TimesheetDTO(Integer timesheetID, String project, String task, Integer  userID, Date dateFrom, Date dateTo, Integer  statusID) {
        this.timesheetID = timesheetID;
        this.project = project;
        this.task = task;
        this.userID = userID;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.statusID = statusID;
    }

    public TimesheetDTO() {
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

    public Integer  getUserID() {
        return userID;
    }

    public void setUserID(Integer  userID) {
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

    public Integer  getStatusID() {
        return statusID;
    }

    public void setStatusID(Integer  statusID) {
        this.statusID = statusID;
    }

    @Override
    public String toString() {
        return "TimesheetDTO{" +
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
