package com.example.study.mapper;

import com.example.study.domain.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper //这个注解表示了本类是一个mybatis 的mapper类
@Repository
public interface StudentMapper {

    @Select(value = "select * from student")
//使用注解方式，也可用xml方式（编写.xml文件放在resources下且要在application.yml中配置localtion等）
    List<Student> selectStudent ();
    //List<User> queryUserList();
    @Insert(value = "insert into user values (#{id},#{name},#{gender},#{DateOfBirth},#{email},#{phone},#{address}," +
            "#{admissionDate},#{graduationDate},#{major},#{gpa})")
    void insertStudent(Student s);
}