package com.example.study.controller;
import com.example.study.utils.Result;
import com.example.study.domain.User;
import com.example.study.dto.UserLoginDto;
import com.example.study.dto.UserRegisterDto;
import com.example.study.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin
@RestController
//@Controller 代表这个类会被springboot 接管
//被@Controller这个注解的类，中的所有方法，如果返回值是String，并且有具体的页面可以跳转，那么就会被视图解析器解析
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    @PostMapping("/save")//用@RequestMapping，则什么请求类型都可以
    //restful接口风格，可以用不同的请求方式实现不同的效果
    //使用@PathVariable注解，让方法参数的值对应绑到一个URL模板变量上
    public Result saveUser(@RequestBody UserRegisterDto userRegisterDto){
        if(userRegisterDto ==null){
            return Result.error("1","对象为空");
        }
        if(userRegisterDto.getUsername()==null|| userRegisterDto.getPassword()==null){
            return Result.error("2","信息不足");
        }
        User user=new User();
        user.setUsername(userRegisterDto.getUsername());
        user.setPassword(userRegisterDto.getPassword());
        user.setPhone(userRegisterDto.getPhone());
        if(!(userService.selectUser(user)==null)){
            return Result.error("3","账号已存在");
        }
        userService.saveUser(user);
        return Result.success(userService.selectUser(user),"注册成功");
    }

    @PostMapping("/login")
    public Result loginIn(@RequestBody UserLoginDto userLoginDto){
        if(userLoginDto==null){
            return Result.error("2","账号密码没输入");
        }
        User user=new User();
        user.setUsername(userLoginDto.getUsername());
        user.setPassword(userLoginDto.getPassword());
        if(userService.selectUser(user)==null){
            return Result.error("1","账号不存在");
        }
        return Result.success(userService.selectUser(user),"登陆成功");
    }
}