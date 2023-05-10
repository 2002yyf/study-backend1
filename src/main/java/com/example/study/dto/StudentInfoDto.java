package com.example.study.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//登录模块数据传输对象
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentInfoDto {
    private Integer snum;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String name;
    private String gender;
    private String major;
    private Double gpa;
    private Integer credit;
    private Integer competitionnum;
    private Integer intershipnum;
    private String grade;
}
