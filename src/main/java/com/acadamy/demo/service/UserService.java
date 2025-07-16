package com.acadamy.demo.service;

import com.acadamy.demo.dto.ResponseDto;
import com.acadamy.demo.dto.UserDto;
import org.springframework.http.ResponseEntity;

public interface UserService {

    public ResponseEntity<ResponseDto> saveUser(UserDto userDto);


}
