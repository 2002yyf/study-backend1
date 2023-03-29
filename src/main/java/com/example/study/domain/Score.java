package com.example.study.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Date;

//User类主要用于Java数据和数据库表的映射
@Data
public class Score implements Serializable {
    private Integer id;
    private Integer sid;
    private Integer cid;
    private Integer score;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date time;
    private double gpa;
    private String status;
}