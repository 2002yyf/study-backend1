package com.example.study.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.study.domain.Course;
import com.example.study.domain.Score;
import com.example.study.mapper.CourseMapper;
import com.example.study.mapper.ScoreMapper;
import com.example.study.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper,Course> implements CourseService {

}