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
public class ScoreAddDto {
    private Integer snum;
    private String name;
    private String major;
    private Integer cid;
    private Integer credit;
    private Double gpa;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date time;
    private Integer score;
}
