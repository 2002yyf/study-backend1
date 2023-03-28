package com.example.study.service.impl;

import com.example.study.domain.Student;
import com.example.study.mapper.StudentMapper;
import com.example.study.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public void saveStudent(Student s){
        studentMapper.insertStudent(s);
    }

    @Override
    public Student selectStudent(Student s){
        return studentMapper.selectStudent(s);
    }




}