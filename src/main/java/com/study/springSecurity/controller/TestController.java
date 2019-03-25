package com.study.springSecurity.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class TestController {

    @RequestMapping("/")
    public String test(){
        return "hello spring boot";
    }


    @RequestMapping("/hello")
    public String test1(){
        return "hello world";
    }
}
