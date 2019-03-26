package com.study.springSecurity.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class TestController {

    @RequestMapping("/")
    public String home(){
        return "hello spring boot";
    }


    @RequestMapping("/hello")
    public String hello(){
        return "hello world";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping("/roleAuth")
    public String role(){
        return "hello roleAuth";
    }

    /**
     * @PreAuthorize 执行前验证
     * @PostAuthorize 执行后验证
     */
    @PreAuthorize("#id<10 and principal.username.equals(userName) and #user.username.equals('admin')")
    @PostAuthorize("returnObject%2==0")
    @RequestMapping("/test")
    public int test(int id, String userName, User user){
        return id;
    }

    /**
     * @PreFilter @PostFilter 操作集合类
     */
    @PreFilter("filterObject%2==0")
    @PostFilter("filterObject%4==0")
    @RequestMapping("/test1")
    public List<Integer> test1(List<Integer> ids){
        return ids;
    }
}
