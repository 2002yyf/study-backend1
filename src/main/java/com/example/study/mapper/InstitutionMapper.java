package com.example.study.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.study.domain.Institution;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper //这个注解表示了本类是一个mybatis 的mapper类
public interface InstitutionMapper extends BaseMapper<Institution> {
    @Select(value = "select count(*) from institution")
//使用注解方式，也可用xml方式（编写.xml文件放在resources下且要在application.yml中配置localtion等）
    Integer sumInstitution ();
}