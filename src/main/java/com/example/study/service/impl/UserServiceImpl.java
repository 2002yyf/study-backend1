package com.example.study.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.study.domain.User;
import com.example.study.mapper.UserMapper;
import com.example.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public void saveUser(User u){
        u.setIsDeleted(0);
        userMapper.insertUser(u);
    }

    @Override
    public User selectUser(User u){
        if(u.getUsername()==null||u.getPassword()==null||u.getIdentity()==null){
            return null;
        }
        return userMapper.selectOneUser(u);
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void addUser(User u){
        userMapper.insert(u);
    }
}