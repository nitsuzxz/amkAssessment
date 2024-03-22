package com.ikhmal.timesheet.Controller;

import com.ikhmal.timesheet.DTO.TimesheetDTO;
import com.ikhmal.timesheet.DTO.TimesheetSaveDTO;
import com.ikhmal.timesheet.Repo.TimesheetRepo;
import com.ikhmal.timesheet.Service.TimesheetService;
import com.ikhmal.timesheet.entity.Timesheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("api/v1/timesheet")
public class TimesheetController {

    @Autowired
    private TimesheetService timesheetService;

    @PostMapping(path="/insertTimesheet")
    public boolean insertTimesheet(@RequestBody TimesheetSaveDTO timesheetSaveDTO){

     return timesheetService.addTimesheet(timesheetSaveDTO);

    }

    @GetMapping(path="/all")
    public List<Map<String, Object>> getAllTimesheetsWithUserAndStatus() {
        return timesheetService.findAllTimesheetsWithUserAndStatus();
    }

    @DeleteMapping(path = "/deleteTimesheet/{id}")
    public boolean deleteTimesheet(@PathVariable(value = "id") int id){
        return timesheetService.deleteTimesheet(id);
    }

    @PostMapping(path = "/updateTimesheet")

    public boolean updateTimesheet(@RequestBody TimesheetDTO timesheetDTO){

        return timesheetService.updateTimesheet(timesheetDTO);
    }
}
