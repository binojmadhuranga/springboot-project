package com.acadamy.demo.service.impl;

import com.acadamy.demo.dto.ResponseDto;
import com.acadamy.demo.dto.UserDto;
import com.acadamy.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceIMPL implements UserService {

    @Override
    public ResponseEntity<ResponseDto> saveUser(UserDto userDto) {
        return null;
    }
}
