package com.ikhmal.timesheet.Service;

import com.ikhmal.timesheet.DTO.StatusDTO;
import com.ikhmal.timesheet.DTO.StatusSaveDTO;

import java.util.List;

public interface StatusService {
    String addStatus(StatusSaveDTO statusSaveDTO);

    List<StatusDTO> getAllStatus();
}
