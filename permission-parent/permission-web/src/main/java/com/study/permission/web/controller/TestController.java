package com.study.permission.web.controller;

import com.study.permission.common.utils.JackJsonUtil;
import com.study.permission.common.utils.SpringContextUtil;
import com.study.permission.model.entity.UserEntity;
import com.study.permission.model.enums.HttpCode;
import com.study.permission.service.common.RedisService;
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
@RequestMapping(value = "/sys/test")
public class TestController {


    @Autowired
    UserService userService;
    @Autowired
    private RedisService redisService;

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

    @ApiOperation(value="测试接口", notes = "测试接口")
    @GetMapping("/test3")
    public UserEntity test3(@ApiParam(name = "id",example = "1") @Min (1)@RequestParam int id) throws IOException {

        UserEntity userEntity = SpringContextUtil.getBean(UserService.class).get(id);

//        log.info(userEntity.getOperatorTime().toString());
        return userEntity;
    }

    @ApiOperation(value="redis测试接口", notes = "redis测试接口")
    @GetMapping("/test4")
    public UserEntity test4() throws IOException {

        UserEntity userEntity = userService.get(1);
        redisService.hashPut("test","user",userEntity);
        userEntity = (UserEntity) redisService.hashGet("test","user");
//        log.info(userEntity.getOperatorTime().toString());
        return userEntity;
    }

}
