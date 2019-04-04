package com.study.permission.web.controller;

import com.study.permission.model.entity.UserEntity;
import com.study.permission.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author caad
 * @date: Create in 11:35 2019/4/4
 */
@RestController
public class TestController {

    @Autowired
    UserService userService;

    @RequestMapping("/test")
    public UserEntity test(){
        return userService.get(1);
    }
}
