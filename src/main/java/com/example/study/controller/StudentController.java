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
//    @PostMapping("/register")//用@RequestMapping，则什么请求类型都可以
//    //restful接口风格，可以用不同的请求方式实现不同的效果
//    //使用@PathVariable注解，让方法参数的值对应绑到一个URL模板变量上
////    public Result savestudent(@RequestBody studentRegisterDto studentRegisterDto){
////        if(studentRegisterDto ==null){
////            return Result.error("1","对象为空");
////        }
////        if(studentRegisterDto.getstudentname()==null|| studentRegisterDto.getPassword()==null||studentRegisterDto.getIdentity()==null){
////            return Result.error("2","信息不足");
////        }
////        student student=new student();
////        student.setstudentname(studentRegisterDto.getstudentname());
////        student.setPassword(studentRegisterDto.getPassword());
////        student.setIdentity(studentRegisterDto.getIdentity());
////        if(!(studentService.selectstudent(student)==null)){
////            return Result.error("3","账号已存在");
////        }
////        studentService.savestudent(student);
////        return Result.success(studentService.selectstudent(student),"注册成功");
////    }
//


    @GetMapping()
    public Result allStudent(){
        List<Student> students = new ArrayList<>();
        students = studentService.findAll();
        return Result.success(students,"查询全部学生信息");
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