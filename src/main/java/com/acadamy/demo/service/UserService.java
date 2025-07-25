package com.acadamy.demo.service;

import com.acadamy.demo.dto.ResponseDto;
import com.acadamy.demo.dto.UserDto;
import org.springframework.http.ResponseEntity;

public interface UserService {

    public ResponseEntity<ResponseDto> saveUser(UserDto userDto);

    public ResponseEntity<ResponseDto> getAllUsers();

    public ResponseEntity<ResponseDto> getUserById(Long id);

    public ResponseEntity<ResponseDto> getUserByName(String name);

    public ResponseEntity<ResponseDto> deleteUser(Long id);
}
