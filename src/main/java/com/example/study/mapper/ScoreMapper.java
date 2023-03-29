package com.example.study.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.study.domain.Score;
import com.example.study.domain.Student;
import com.example.study.dto.StudentLearnDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper //这个注解表示了本类是一个mybatis 的mapper类
public interface ScoreMapper extends BaseMapper<Score> {

    @Select(value = "select a.cid,a.score,a.time,a.gpa,a.status,b.name,b.credit,b.hour,b.type from score as a inner join course as b on a.cid = b.id where a.sid = #{id}")
    List<StudentLearnDto> selectScore(Integer id);
}