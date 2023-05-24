package com.example.study.controller;
import com.example.study.domain.Course;
import com.example.study.domain.User;
import com.example.study.dto.StudentInfoDto;
import com.example.study.dto.StudentLearnDto;
import com.example.study.service.CourseService;
import com.example.study.service.ScoreService;
import com.example.study.service.UserService;
import com.example.study.utils.Result;
import com.example.study.domain.Student;
import com.example.study.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
//@Controller 代表这个类会被springboot 接管
//被@Controller这个注解的类，中的所有方法，如果返回值是String，并且有具体的页面可以跳转，那么就会被视图解析器解析
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private ScoreService scoreService;
    @Autowired
    private UserService userService;
    @GetMapping("/information")
    public Result<Student> allStudent(@RequestParam Integer id){
        Student student = new Student();
        student.setId(id);
        student = studentService.getById(id);
        return Result.success(student,"id为"+id+"的学生信息");
    }

    @PostMapping("/edit")
    public Result<Student> editStudent(@RequestBody Student s){
        studentService.updateById(s);
        return Result.success(s,"修改成功");
    }

    //查学分
    @GetMapping("/credit")
    public Result<List<StudentLearnDto>> creditInformation(@RequestParam Integer id,@RequestParam String major){
        List<StudentLearnDto> sld = scoreService.selectScore(id,major);
        return Result.success(sld,"查询成功");
    }

    @GetMapping("/sum")
    public Result<Integer> sumStudent(){
        return Result.success(studentService.sumStudent(),"学生总数查询成果");
    }

    @GetMapping("/totalCourse")
    public Result<List<Course>> totalCourse(@RequestParam String major){
        return Result.success(courseService.totalCourse(major),"该学生需要学的全部课程");
    }

    @GetMapping("/studentInfo")
    public Result<List<StudentInfoDto>> studentInfo(){
        return Result.success(scoreService.studentInfo(),"全部学生信息");
    }

    @PostMapping("/addStudent")
    public Result addStudent(@RequestBody Student s){
        studentService.addStudent(s);
        User u = new User();
        u.setUsername(s.getSnum().toString());
        u.setPassword(s.getSnum().toString());
        userService.addUser(u);
        return Result.success(null,"添加成功");
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