package com.example.study.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.study.domain.Experience;

import java.util.List;

public interface ExperienceService extends IService<Experience> {
    public List<Experience> findAll(Integer sid);
    public void add()
}