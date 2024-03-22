package com.ikhmal.timesheet.DTO;

public class StatusSaveDTO {

    private String statusDescription;

    public StatusSaveDTO(String statusDescription) {
        this.statusDescription = statusDescription;
    }
    public StatusSaveDTO(){

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
                "statusDescription='" + statusDescription + '\'' +
                '}';
    }
}
