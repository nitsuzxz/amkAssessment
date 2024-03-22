package com.ikhmal.timesheet.Service;

import com.ikhmal.timesheet.DTO.UserDTO;
import com.ikhmal.timesheet.DTO.UserSaveDTO;

import java.util.List;

public interface UserService {
    String addUser(UserSaveDTO userSaveDTO);

    List<UserDTO> getAllUser();
}
