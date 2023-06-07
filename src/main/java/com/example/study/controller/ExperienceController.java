package com.example.study.controller;
import com.baomidou.mybatisplus.extension.api.R;
import com.example.study.domain.Experience;
import com.example.study.domain.Institution;
import com.example.study.service.ExperienceService;
import com.example.study.service.InstitutionService;
import com.example.study.utils.Result;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.PrimitiveIterator;

@CrossOrigin
@RestController
//@Controller 代表这个类会被springboot 接管
//被@Controller这个注解的类，中的所有方法，如果返回值是String，并且有具体的页面可以跳转，那么就会被视图解析器解析
@RequestMapping("/experience")
public class ExperienceController {
    @Autowired
    private ExperienceService experienceService;

    @GetMapping("/all")
    public Result<List<Experience>> allExperience(@RequestParam Integer sid){
        return Result.success(experienceService.findAll(sid),"id为"+sid+"全部实习经历");
    }

    @PostMapping("/add")
    public Result<Experience> addExperience(@RequestBody Experience e){

        experienceService.add(e);
        return Result.success(e,"插入成功");
    }

    @GetMapping("/notAudit")
    public Result<List<Experience>> notAudit(){
        List<Experience> e = experienceService.not_audit();
        return Result.success(e,"未批阅经历名单");
    }

    @PostMapping("/audit")
    public Result audit(Integer id,Integer pass){
        experienceService.audit(id,pass);
        return Result.success(null,"修改成功");
    }
}