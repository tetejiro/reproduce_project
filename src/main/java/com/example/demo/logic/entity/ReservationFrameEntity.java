package com.example.demo.logic.entity;

import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
public class ReservationFrameEntity {
    public int id;
    public int hospital_id;
    public LocalDate target_date;
    public LocalTime target_time;
}
