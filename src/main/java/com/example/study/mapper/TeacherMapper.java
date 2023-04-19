package com.example.study.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.study.domain.Teacher;
import org.apache.ibatis.annotations.Mapper;


@Mapper //这个注解表示了本类是一个mybatis 的mapper类
public interface TeacherMapper extends BaseMapper<Teacher> {

}