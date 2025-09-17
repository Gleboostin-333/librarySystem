package com.library.system.services;


import com.library.system.dtos.UserDto;
import com.library.system.model.User;
import com.library.system.services.interfaces.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServicelmpl implements UserService {

    public User createUser(UserDto userDto) {
        User user = new User();

        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());


        return user;
    }

}
