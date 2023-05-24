package com.example.study.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.study.domain.Student;
import com.example.study.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService  extends IService<User> {
    void saveUser(User u);
    User selectUser(User u);
    List<User> findAll();
    void addUser(User u);
}