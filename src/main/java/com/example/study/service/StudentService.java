package com.example.study.service;

import com.example.study.domain.Student;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentService {
    void saveStudent(Student s);
    Student selectStudent(Student s);
    List<Student> findAll();

}