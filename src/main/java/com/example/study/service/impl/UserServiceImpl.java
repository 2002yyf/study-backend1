package com.example.study.service.impl;

import com.example.study.domain.User;
import com.example.study.mapper.UserMapper;
import com.example.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public void saveUser(User u){
        u.setIsDelete(0);
        userMapper.insertUser(u);
    }

    @Override
    public User selectUser(User u){
        if(u.getUsername()==null||u.getPassword()==null){
            return null;
        }
        return userMapper.selectOneUser(u);
    }

    @Override
    public List<User> findAll() {
        return null;
    }


}