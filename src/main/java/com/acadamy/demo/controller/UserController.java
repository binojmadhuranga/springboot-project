package com.acadamy.demo.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/user")
@CrossOrigin
@RestController

public class UserController {

    @GetMapping("get")
    public  String test() {
        return "Hello from UserController";
    }



}
