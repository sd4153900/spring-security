package com.study.permission.web.controller;

import com.study.permission.model.form.DeptForm;
import com.study.permission.service.common.RedisService;
import com.study.permission.service.service.DeptService;
import com.study.permission.web.response.HttpResult;
import com.study.permission.web.response.ResultFactory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author caad
 * @date: Create in 15:49 2019/4/9
 */
@Api(value="DeptController", tags="部门接口模块")
@RestController
@RequestMapping("/sys/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @ApiOperation(value = "新增部门",notes = "新增部门",httpMethod = "POST")
    @PostMapping()
    public HttpResult save(@Valid @RequestBody DeptForm deptForm){
        deptService.save(deptForm);
        return ResultFactory.ok();
    }

    @ApiOperation(value = "获取部门树",notes = "获取部门树",httpMethod = "GET")
    @GetMapping("/tree")
    public HttpResult getTree(){
        return  HttpResult.ok(deptService.getDeptTree());
    }
}
