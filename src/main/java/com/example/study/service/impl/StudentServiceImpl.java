package com.example.study.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.study.domain.Student;
import com.example.study.mapper.StudentMapper;
import com.example.study.service.StudentService;
import org.springframework.stereotype.Service;


@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper,Student> implements StudentService {
}