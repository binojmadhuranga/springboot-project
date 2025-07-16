package com.acadamy.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "User_Name")
    private String name;

    @Column(name = "User_Age")
    private int age;




}
