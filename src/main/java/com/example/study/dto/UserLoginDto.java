package com.example.study.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//登录模块数据传输对象
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDto {
    private String username;
    private String password;
}
