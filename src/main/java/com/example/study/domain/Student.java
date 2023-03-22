package com.example.study.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

//User类主要用于Java数据和数据库表的映射
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int id;
    private String name;
    private Byte gender;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date DateOfBirth;
    private String email;
    private String phone;
    private String address;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date admissionDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date graduationDate;
    private String major;
    private Double gpa;
}