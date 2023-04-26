package com.example.study.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.study.domain.Experience;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper //这个注解表示了本类是一个mybatis 的mapper类
public interface ExperienceMapper extends BaseMapper<Experience> {
//    @Select(value = "select * from course where major = #{major}")
//    List<Course> totalCourse(String major);
}