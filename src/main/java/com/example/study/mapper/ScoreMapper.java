package com.example.study.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.study.domain.Score;
import com.example.study.domain.Student;
import com.example.study.dto.StudentInfoDto;
import com.example.study.dto.StudentLearnDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper //这个注解表示了本类是一个mybatis 的mapper类
public interface ScoreMapper extends BaseMapper<Score> {

    @Select(value = "select a.cid,a.score,a.time,a.gpa,a.status,b.name,b.credit,b.hour,b.type from (select * from score where sid = #{id})" +
            " as a right join course as b on a.cid = b.id where major = #{major}")
    List<StudentLearnDto> selectScore(Integer id,String major);

    @Select(value = "select snum,name,gender,birthday,major,(select avg(gpa) from score where sid = student.id) as gpa," +
            "(select sum(credit) from score s inner join course c on s.cid = c.id where s.sid = student.id and s.status = '通过')" +
            " as credit,(select count(*) from experience where type = '竞赛' and sid = student.id) as competitionnum," +
            "(select count(*) from experience where type = '实习' and sid = student.id) as intershipnum,grade from student")
    List<StudentInfoDto> studentInfo();




}