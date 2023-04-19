package com.example.study.controller;
import com.example.study.domain.Teacher;
import com.example.study.service.TeacherService;
import com.example.study.utils.Result;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
//@Controller 代表这个类会被springboot 接管
//被@Controller这个注解的类，中的所有方法，如果返回值是String，并且有具体的页面可以跳转，那么就会被视图解析器解析
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;


    @PostMapping("/edit")
    public Result<Teacher> editTeacher(@RequestBody Teacher t){
        teacherService.updateById(t);
        return Result.success(t,"修改成功");
    }

    @GetMapping("/information")
    public Result<Teacher> selectTeacher(@RequestParam Integer id){
        Teacher t = teacherService.getById(id);
        if(t!= null)
        return Result.success(t,"查询成果");
        else return Result.error("1","无此用户");
    }





}