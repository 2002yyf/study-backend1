package com.example.study.domain;

import lombok.Data;

import java.io.Serializable;

//User类主要用于Java数据和数据库表的映射
@Data
public class Course implements Serializable {
    private Integer id;
    private String name;
    private Integer credit;
    private Integer hour;
    private String type;

}