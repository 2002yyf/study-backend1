package com.example.study.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Date;

//User类主要用于Java数据和数据库表的映射
@Data
public class Student implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;
    private Integer snum;
    private String gender;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date birthday;
    private String email;
    private String phone;
    private String address;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date graduationDate;
    private String major;
    private String grade;
    private String introduction;
}