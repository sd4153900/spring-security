package com.study.permission.web.exception;

import com.study.permission.web.response.HttpResult;
import com.study.permission.web.response.ResultFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(WebException.class)
    @ResponseBody
    public HttpResult webExceptionHandler(WebException exception){
        log.error(exception.getMessage(),exception);
        return ResultFactory.build(exception.getCode(),exception.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public HttpResult exceptionHandler(Exception exception){
        log.error(exception.getMessage(),exception);
        return ResultFactory.error(exception.getMessage());
    }
}
