package com.ikhmal.timesheet.Controller;

import com.ikhmal.timesheet.DTO.StatusDTO;
import com.ikhmal.timesheet.DTO.StatusSaveDTO;
import com.ikhmal.timesheet.Service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/status")

public class StatusController {

    @Autowired
    private StatusService statusService;

    @PostMapping(path = "/insertStatus")
    public String insertStatus(@RequestBody StatusSaveDTO statusSaveDTO){

       return statusService.addStatus(statusSaveDTO);
    }

    @GetMapping(path = "/getStatus")
    public List<StatusDTO> getAllStatus(){

        List<StatusDTO>allStatus = statusService.getAllStatus();
        return allStatus;
    }

}
