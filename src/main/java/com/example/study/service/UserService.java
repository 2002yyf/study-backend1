package com.example.study.service;

import com.example.study.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    void saveUser(User u);
    User selectUser(User u);
    List<User> findAll();

}