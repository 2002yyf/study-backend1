package com.example.study.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Date;

//User类主要用于Java数据和数据库表的映射
@Data
public class Institution implements Serializable {
    private Integer id;
    private String name;
    private String address;
    private String type;
    private String email;
    private String phone;
    private String introduction;
}