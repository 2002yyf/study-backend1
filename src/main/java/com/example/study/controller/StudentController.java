package com.example.study.controller;
import com.example.study.utils.Result;
import com.example.study.domain.Student;
import com.example.study.service.StudentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
//@Controller 代表这个类会被springboot 接管
//被@Controller这个注解的类，中的所有方法，如果返回值是String，并且有具体的页面可以跳转，那么就会被视图解析器解析
@RequestMapping("/student")
public class StudentController {
    @Resource
    private StudentService studentService;

    @GetMapping("/information")
    public Result allStudent(@RequestParam Integer id){
        Student student = new Student();
        student.setId(id);
        student = studentService.selectStudent(student);
        return Result.success(student,"id为"+id+"的学生信息");
    }

//    @PostMapping("/login")
//    public Result loginIn(@RequestBody studentLoginDto studentLoginDto){
//        if(studentLoginDto==null){
//            return Result.error("2","对象为空");
//        }
//        Student student=new Student();
//        student.setstudentname(studentLoginDto.getstudentname());
//        student.setPassword(studentLoginDto.getPassword());
//        student.setIdentity(studentLoginDto.getIdentity());
//        if(studentService.selectstudent(student)==null){
//            return Result.error("1","账号不存在");
//        }
//        return Result.success(studentService.selectstudent(student),"登陆成功");
//    }
}