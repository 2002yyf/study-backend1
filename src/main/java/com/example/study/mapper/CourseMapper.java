package com.example.study.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.study.domain.Course;
import com.example.study.domain.Student;
import org.apache.ibatis.annotations.Mapper;


@Mapper //这个注解表示了本类是一个mybatis 的mapper类
public interface CourseMapper extends BaseMapper<Course> {

}