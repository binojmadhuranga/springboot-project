package com.acadamy.demo.service.impl;

import com.acadamy.demo.dto.ResponseDto;
import com.acadamy.demo.dto.UserDto;
import com.acadamy.demo.entity.User;
import com.acadamy.demo.repo.UserRepo;
import com.acadamy.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceIMPL implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public ResponseEntity<ResponseDto> saveUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setAge(userDto.getAge());
        userRepo.save(user);

        return new ResponseEntity<>(ResponseDto.builder().
                message("User saved successfully").
                data(userDto).
                build(), HttpStatus.CREATED);
    }
}
