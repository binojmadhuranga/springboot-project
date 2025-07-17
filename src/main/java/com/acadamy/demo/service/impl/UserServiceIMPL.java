package com.acadamy.demo.service.impl;

import com.acadamy.demo.dto.ResponseDto;
import com.acadamy.demo.dto.UserDto;
import com.acadamy.demo.entity.User;
import com.acadamy.demo.repo.UserRepo;
import com.acadamy.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@Service
public class UserServiceIMPL implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public ResponseEntity<ResponseDto> saveUser(UserDto userDto) {


        try {
            User user = new User();
            user.setName(userDto.getName());
            user.setAge(userDto.getAge());
            userRepo.save(user);

            return new ResponseEntity<>(ResponseDto.builder().
                    message("User saved successfully").
                    data(userDto).
                    build(), HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Fail to save user", e);
            return new ResponseEntity<>(ResponseDto.builder().
                    message("Fail to save user").
                    data(userDto).
                    build(), HttpStatus.BAD_REQUEST);
        }
    }


    @Override
    public ResponseEntity<ResponseDto> getAllUsers() {
        try {
            List<UserDto> userDtoList = new ArrayList<>();
            List<User> users = userRepo.findAll();

            if (users.isEmpty()) {
                return new ResponseEntity<>(
                        ResponseDto.builder()
                                .message("No users found")
                                .data(Collections.emptyList())
                                .statusCode(HttpStatus.NOT_FOUND.value())
                                .build(),
                        HttpStatus.NOT_FOUND
                );
            }

            for (User user : users) {
                UserDto userDto = new UserDto();
                userDto.setName(user.getName());
                userDto.setAge(user.getAge());
                userDtoList.add(userDto);
            }

            return new ResponseEntity<>(
                    ResponseDto.builder()
                            .message("Users fetched successfully")
                            .data(userDtoList)
                            .statusCode(HttpStatus.OK.value())
                            .build(),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            log.error("Error fetching users", e);
            return new ResponseEntity<>(
                    ResponseDto.builder()
                            .message("Error fetching users")
                            .data(null)
                            .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build(),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }


    @Override
    public ResponseEntity<ResponseDto> getUserById(Long id) {
        //Optional<User> userOptional = userRepo.findById(id);
        Optional<User> userOptional = userRepo.findById(id);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return new ResponseEntity<>(ResponseDto.builder().
                    message("User fetched successfully").
                    data(user).
                    build(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(ResponseDto.builder().
                    message("User not found").
                    data(null).
                    build(), HttpStatus.NOT_FOUND);
        }

    }


}
