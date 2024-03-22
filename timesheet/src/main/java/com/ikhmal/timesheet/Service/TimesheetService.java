package com.ikhmal.timesheet.Service;

import com.ikhmal.timesheet.DTO.TimesheetDTO;
import com.ikhmal.timesheet.DTO.TimesheetSaveDTO;
import com.ikhmal.timesheet.entity.Timesheet;

import java.util.List;
import java.util.Map;

public interface TimesheetService {
    boolean addTimesheet(TimesheetSaveDTO timesheetSaveDTO);
    List<Map<String, Object>> findAllTimesheetsWithUserAndStatus();

    boolean deleteTimesheet(int id);

    boolean updateTimesheet(TimesheetDTO timesheetDTO);
}
