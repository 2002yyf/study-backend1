package com.example.study.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
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

    @Override
    public List<Experience> not_audit(){
        QueryWrapper<Experience> wrapper = new QueryWrapper<>();
        wrapper.eq("status","待批阅");
        return experienceMapper.selectList(wrapper);
    }
    @Override
    public void audit(Integer id,Integer pass){
        UpdateWrapper<Experience> updateWrapper = new UpdateWrapper<>();
        if (pass == 1) {
            updateWrapper.eq("id", id).set("status", "已通过");
        }else if (pass ==0){
            updateWrapper.eq("id", id).set("status", "不通过");
        }
        Integer rows = experienceMapper.update(null, updateWrapper);
    }
}

