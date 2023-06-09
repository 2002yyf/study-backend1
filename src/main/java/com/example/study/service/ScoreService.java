package com.example.study.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.study.domain.Score;
import com.example.study.domain.Student;
import com.example.study.dto.ScoreInfoDto;
import com.example.study.dto.StudentInfoDto;
import com.example.study.dto.StudentLearnDto;
import com.example.study.dto.StudentScoreDto;
import org.apache.ibatis.annotations.Delete;

import java.util.List;


public interface ScoreService extends IService<Score> {
    List<StudentLearnDto> selectScore(Integer id,String major);
    List<StudentInfoDto> studentInfo();
    void addScore(Score s);
    List<ScoreInfoDto> scoreInfo();
    List<StudentScoreDto> studentScore(Integer id);
}