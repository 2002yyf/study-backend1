package com.example.study.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.study.domain.Teacher;
import com.example.study.mapper.TeacherMapper;
import com.example.study.service.TeacherService;
import org.springframework.stereotype.Service;


@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {
}