package com.example.study.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.study.domain.Course;

import java.util.List;


public interface CourseService extends IService<Course> {
    public List<Course> totalCourse(String major);
}