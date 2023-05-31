package com.example.study.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.study.domain.Student;
import com.example.study.mapper.StudentMapper;
import com.example.study.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper,Student> implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public Integer sumStudent(){
        return studentMapper.sumStudent();
    }
    @Override
    public void addStudent(Student s){
        studentMapper.insert(s);
    }
    @Override
    public List<Student> allInfo(){
        return studentMapper.selectList(null);
    }
}