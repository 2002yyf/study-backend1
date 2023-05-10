package com.example.study.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.study.domain.Score;
import com.example.study.dto.StudentInfoDto;
import com.example.study.dto.StudentLearnDto;
import com.example.study.mapper.ScoreMapper;
import com.example.study.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class ScoreServiceImpl extends ServiceImpl<ScoreMapper, Score> implements ScoreService {

    @Autowired
    ScoreMapper scoreMapper;
    @Override
    public List<StudentLearnDto> selectScore(Integer id,String major){
//        Map<String,Object> columnMap = new HashMap<>();
//        columnMap.put("sid",id);
        return scoreMapper.selectScore(id,major);
    }
    @Override
    public List<StudentInfoDto> studentInfo(){
        return scoreMapper.studentInfo();
    }
}