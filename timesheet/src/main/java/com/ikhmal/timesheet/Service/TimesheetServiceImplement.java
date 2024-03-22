package com.ikhmal.timesheet.Service;

import com.ikhmal.timesheet.DTO.TimesheetDTO;
import com.ikhmal.timesheet.DTO.TimesheetSaveDTO;
import com.ikhmal.timesheet.Repo.TimesheetRepo;
import com.ikhmal.timesheet.entity.Status;
import com.ikhmal.timesheet.entity.Timesheet;
import com.ikhmal.timesheet.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TimesheetServiceImplement implements TimesheetService {
    @Autowired
    private TimesheetRepo timesheetRepo;

    @Override
    public boolean addTimesheet(TimesheetSaveDTO timesheetSaveDTO) {
        try {
            Timesheet timesheet = new Timesheet(
                    timesheetSaveDTO.getProject(),
                    timesheetSaveDTO.getTask(),
                    timesheetSaveDTO.getUserID(),
                    timesheetSaveDTO.getDateFrom(),
                    timesheetSaveDTO.getDateTo(),
                    timesheetSaveDTO.getStatusID()
            );
            timesheetRepo.save(timesheet);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public List<Map<String, Object>> findAllTimesheetsWithUserAndStatus() {
        List<Object[]> resultList = timesheetRepo.findAllTimesheetsWithUserAndStatus();
        List<Map<String, Object>> responseList = new ArrayList<>();

        for (Object[] result : resultList) {
            Map<String, Object> map = new HashMap<>();
            map.put("timesheet", (Timesheet) result[0]);
            map.put("user", (User) result[1]);
            map.put("status", (Status) result[2]);
            responseList.add(map);
        }

        return responseList;
    }

    @Override

    public boolean deleteTimesheet(int id){

        try{
            if(timesheetRepo.existsById(id)){
                timesheetRepo.deleteById(id);
                return true;
            }else{
                return false;
            }
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean updateTimesheet(TimesheetDTO timesheetDTO) {

        if (timesheetRepo.existsById(timesheetDTO.getTimesheetID())) {
            Timesheet timesheet = timesheetRepo.getById(timesheetDTO.getTimesheetID());
            timesheet.setProject(timesheetDTO.getProject());
            timesheet.setTask(timesheetDTO.getTask());
            timesheet.setUserID(timesheetDTO.getUserID());
            timesheet.setDateFrom(timesheetDTO.getDateFrom());
            timesheet.setDateTo(timesheetDTO.getDateTo());
            timesheet.setStatusID(timesheetDTO.getStatusID());

            timesheetRepo.save(timesheet);
            return true;
        } else {
            return false;
        }
    }
}
