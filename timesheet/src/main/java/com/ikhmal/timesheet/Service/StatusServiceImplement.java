package com.ikhmal.timesheet.Service;

import com.ikhmal.timesheet.DTO.StatusDTO;
import com.ikhmal.timesheet.DTO.StatusSaveDTO;
import com.ikhmal.timesheet.Repo.StatusRepo;
import com.ikhmal.timesheet.entity.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatusServiceImplement implements StatusService{
    @Autowired
    private StatusRepo statusRepo;
    @Override
    public String addStatus(StatusSaveDTO statusSaveDTO) {

        Status status= new Status(
                statusSaveDTO.getStatusDescription()
        );
        statusRepo.save(status);
        return status.getStatusDescription();
    }

    @Override
    public List<StatusDTO> getAllStatus() {

        List<Status> getStatus = statusRepo.findAll();
        List<StatusDTO> statusDTOList= new ArrayList<>();

        for(Status a:getStatus){

            StatusDTO statusDTO = new StatusDTO(
                    a.getStatusID(),
                    a.getStatusDescription()
            );

            statusDTOList.add(statusDTO);
        }

        return statusDTOList;
    }
}
