package com.example.demo.logic.entity;

import lombok.AllArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
public class UserEntity {
    public int id;
    public String name;
    public String gender;
    public LocalDate birthday;
}
