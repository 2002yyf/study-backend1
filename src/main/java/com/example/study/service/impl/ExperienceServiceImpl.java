package com.example.study.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.study.domain.Experience;
import com.example.study.mapper.ExperienceMapper;
import com.example.study.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceServiceImpl extends ServiceImpl<ExperienceMapper, Experience> implements ExperienceService {
    @Autowired
    private ExperienceMapper experienceMapper;

    @Override
    public List<Experience> findAll(Integer sid){
        QueryWrapper<Experience> wrapper = new QueryWrapper<>();
        wrapper.eq("sid",sid);
        return experienceMapper.selectList(wrapper);
    }
    @Override
    public void add(Experience e){
        experienceMapper.insert(e);
    }

    @Override
    public void saveE(Experience e){
        experienceMapper.updateById(e);
    }
}