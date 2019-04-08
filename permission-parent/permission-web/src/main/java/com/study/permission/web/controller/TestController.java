package com.study.permission.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.study.permission.common.json.JackJsonUtil;
import com.study.permission.model.entity.UserEntity;
import com.study.permission.model.enums.HttpCode;
import com.study.permission.service.service.UserService;
import com.study.permission.web.exception.WebException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.io.IOException;

/**
 * @author caad
 * @date: Create in 11:35 2019/4/4
 */
@Validated
@Api(value="/", tags="测试接口模块")
@Slf4j
@RestController
@RequestMapping(value = "/api")
public class TestController {


    @Autowired
    UserService userService;

    @ApiOperation(value="测试接口", notes = "测试接口")
    @GetMapping("/test")
    public UserEntity test(@ApiParam(name = "id",example = "1") @Min (1)@RequestParam int id) throws IOException {
        log.info("log 测试");
//        int aa = 2/id;
        if(id == 0){
            throw new WebException(HttpCode.FAIL,"参数错误");
        }
        UserEntity userEntity = userService.get(id);
        String json = JackJsonUtil.toJson(userEntity);
        log.info(json);
        userEntity = JackJsonUtil.toObject(json,UserEntity.class);
//        log.info(userEntity.getOperatorTime().toString());
        return userEntity;
    }

    @ApiOperation(value="测试接口2", notes = "测试接口2")
    @PostMapping("/test2")
    public UserEntity test2(@ApiParam(name = "userEntity") @RequestBody @Valid UserEntity userEntity){
        log.info("log 测试");
        //UserEntity userEntity = userService.get(id);
//        log.info(userEntity.getOperatorTime().toString());
        return userEntity;
    }
}
