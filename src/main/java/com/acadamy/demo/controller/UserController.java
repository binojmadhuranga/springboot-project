package com.acadamy.demo.controller;


import com.acadamy.demo.dto.ResponseDto;
import com.acadamy.demo.dto.UserDto;
import com.acadamy.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/user")
@CrossOrigin
@RestController

public class UserController {

//    @GetMapping("get")
//    public  String test() {
//        return "Hello from UserController";
//    }

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDto> saveUser(@RequestBody UserDto userDto)
    {
        return userService.saveUser(userDto);
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseDto> getAllUsers()
    {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> getUserById(@PathVariable Long id)
    {
        return userService.getUserById(id);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<ResponseDto> getUserByName(@PathVariable String name)
    {
        return userService.getUserByName(name);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteUser(@PathVariable Long id)
    {
        return userService.deleteUser(id);
    }



}
