package com.example.study.controller;

import com.example.study.domain.Institution;
import com.example.study.service.InstitutionService;
import com.example.study.utils.Result;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
//@Controller 代表这个类会被springboot 接管
//被@Controller这个注解的类，中的所有方法，如果返回值是String，并且有具体的页面可以跳转，那么就会被视图解析器解析
@RequestMapping("/institution")
public class InstitutionController {
    @Autowired
    private InstitutionService institutionService;


    @PostMapping("/edit")
    public Result<Institution> editInstitution(@RequestBody Institution i) {
        Integer id = i.getId();
        Institution institution = institutionService.getById(id);
        if (institution == null) {
            return Result.error("1", "无此机构");
        } else {
            institutionService.updateById(i);

            return Result.success(institution, "修改成功");
        }
    }

    @GetMapping("/information")
    public Result<Institution> selectInstitution(@RequestParam Integer id) {
        Institution i = institutionService.getById(id);
        if (i != null)
            return Result.success(i, "查询成果");
        else return Result.error("1", "无此机构");
    }
    @GetMapping("/sum")
    public Result<Integer> sumInstitution(){
        return Result.success(institutionService.sumInstitution(),"机构总数查询成果");
    }

}