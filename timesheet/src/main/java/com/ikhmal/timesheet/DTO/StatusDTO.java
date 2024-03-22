package com.ikhmal.timesheet.DTO;

public class StatusDTO {


    private int statusID;
    private String statusDescription;

    public StatusDTO(int statusID, String statusDescription) {
        this.statusID = statusID;
        this.statusDescription = statusDescription;
    }
    public StatusDTO(){

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
        return "StatusDTO{" +
                "statusID=" + statusID +
                ", statusDescription='" + statusDescription + '\'' +
                '}';
    }
}
