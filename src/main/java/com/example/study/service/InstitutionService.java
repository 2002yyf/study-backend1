package com.example.study.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.study.domain.Course;
import com.example.study.domain.Institution;

import java.util.List;


public interface InstitutionService extends IService<Institution> {
    public Integer sumInstitution();
}