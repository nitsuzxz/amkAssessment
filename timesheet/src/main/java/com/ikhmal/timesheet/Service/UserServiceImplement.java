package com.ikhmal.timesheet.Service;

import com.ikhmal.timesheet.DTO.UserDTO;
import com.ikhmal.timesheet.DTO.UserSaveDTO;
import com.ikhmal.timesheet.Repo.UserRepo;
import com.ikhmal.timesheet.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImplement implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public String addUser(UserSaveDTO userSaveDTO) {
        User user= new User(
                userSaveDTO.getName()
        );
        userRepo.save(user);
        return userSaveDTO.getName();
    }

    @Override
    public List<UserDTO> getAllUser(){

        List<User> getUser= userRepo.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();

        for(User a:getUser){

            UserDTO userDTO= new UserDTO(
                    a.getUserID(),
                    a.getName()
            );

            userDTOList.add(userDTO);
        }

        return userDTOList;
    }
}
