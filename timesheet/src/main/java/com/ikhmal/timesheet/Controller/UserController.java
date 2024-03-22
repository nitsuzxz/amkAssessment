package com.ikhmal.timesheet.Controller;

import com.ikhmal.timesheet.DTO.UserDTO;
import com.ikhmal.timesheet.DTO.UserSaveDTO;
import com.ikhmal.timesheet.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(path = "/insertUser")
    public String insertUser(@RequestBody UserSaveDTO userSaveDTO){

        return userService.addUser(userSaveDTO);
    }

    @GetMapping(path= "/getAllUser")
    public List<UserDTO> getAllUser(){

        List<UserDTO> allUser = userService.getAllUser();
        return allUser;
    }
}
