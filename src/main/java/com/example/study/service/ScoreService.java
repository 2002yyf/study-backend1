package com.example.study.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.study.domain.Score;
import com.example.study.domain.Student;
import com.example.study.dto.StudentLearnDto;

import java.util.List;


public interface ScoreService extends IService<Score> {
    List<StudentLearnDto> selectScore(Integer id);
}