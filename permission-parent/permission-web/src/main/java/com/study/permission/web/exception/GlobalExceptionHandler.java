package com.study.permission.web.exception;

import com.study.permission.web.response.HttpResult;
import com.study.permission.web.response.ResultFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(WebException.class)
    @ResponseBody
    public HttpResult exceptionHandler(WebException exception){
        return ResultFactory.build(exception.getCode(),exception.getMessage());
    }
}
