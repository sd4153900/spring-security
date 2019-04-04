package com.study.permission.web.controller;

import com.study.permission.model.entity.UserEntity;
import com.study.permission.service.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author caad
 * @date: Create in 11:35 2019/4/4
 */
@Api(value="/", tags="测试接口模块")
@Slf4j
@RestController
public class TestController {


    @Autowired
    UserService userService;

    @ApiOperation(value="测试接口", notes = "测试接口")
    @GetMapping("/test")
    public UserEntity test(@ApiParam(name = "id") @RequestParam int id){
        log.info("log 测试");
        return userService.get(id);
    }
}
