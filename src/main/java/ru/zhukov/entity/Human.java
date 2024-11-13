package ru.zhukov.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public abstract class Human {

    private String fullName;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private String address;
}
