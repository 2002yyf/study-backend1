package com.example.study.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.study.domain.Experience;

import java.util.List;

public interface ExperienceService extends IService<Experience> {
    List<Experience> findAll(Integer sid);
    void add(Experience e);
    void saveE(Experience e);
    List<Experience> not_audit();
    void audit(Integer id,Integer pass);
}