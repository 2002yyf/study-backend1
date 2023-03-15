package com.example.study.mapper;

import com.example.study.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper //这个注解表示了本类是一个mybatis 的mapper类
//或者在主类写@MapperScan("com.example.study.mapper")
@Repository
public interface UserMapper {

    @Select(value = "select * from user where username=#{username} and password = #{password} and identity = #{identity}")
//使用注解方式，也可用xml方式（编写.xml文件放在resources下且要在application.yml中配置localtion等）
    User selectOneUser (User u);
    //List<User> queryUserList();
    @Insert(value = "insert into user values (#{id},#{username},#{password},#{phone},#{isDelete},#{identity})")
    void insertUser(User U);
}