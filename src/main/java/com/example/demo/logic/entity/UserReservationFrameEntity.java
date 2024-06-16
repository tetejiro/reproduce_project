package com.example.demo.logic.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;

@Getter
@AllArgsConstructor
public class UserReservationFrameEntity {
    public UserEntity user;
    public ReservationFrameEntity schedule;
    public String type;
    public Instant timestamp;
}
