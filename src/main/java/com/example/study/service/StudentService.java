package com.example.study.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.study.domain.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService extends IService<Student> {
    Integer sumStudent();
    void addStudent(Student s);
    List<Student> allInfo();
}