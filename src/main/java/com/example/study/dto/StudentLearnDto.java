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
public class StudentLearnDto {
    private Integer id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date time;
    private String name;
    private Integer credit;
    private Integer hour;
    private String type;
    private Integer score;
    private Double gpa;
    private String status;
}
