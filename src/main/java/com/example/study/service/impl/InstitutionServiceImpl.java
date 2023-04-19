package com.example.study.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.study.domain.Institution;
import com.example.study.domain.Student;
import com.example.study.mapper.InstitutionMapper;
import com.example.study.mapper.StudentMapper;
import com.example.study.service.InstitutionService;
import com.example.study.service.StudentService;
import org.springframework.stereotype.Service;


@Service
public class InstitutionServiceImpl extends ServiceImpl<InstitutionMapper, Institution> implements InstitutionService {
}