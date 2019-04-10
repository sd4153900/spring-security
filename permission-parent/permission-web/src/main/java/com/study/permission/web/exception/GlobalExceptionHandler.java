package com.study.permission.web.exception;

import com.study.permission.model.enums.HttpCode;
import com.study.permission.web.response.HttpResult;
import com.study.permission.web.response.ResultFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public HttpResult exceptionHandler(Exception exception){
        log.error(exception.getMessage(),exception);
        return ResultFactory.error(exception.getMessage());
    }

    @ExceptionHandler(WebException.class)
    @ResponseBody
    public HttpResult webExceptionHandler(WebException exception){
        log.error(exception.getMessage(),exception);
        return ResultFactory.build(exception.getCode(),exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public HttpResult methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception){
        BindingResult bindingResult = exception.getBindingResult();
        String message;
        if (bindingResult.hasErrors()){
            List<String> errorList = bindingResult.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.toList());
            message = StringUtils.join(errorList,";");
        }else{
            message = exception.getMessage();
        }
        log.error(message,exception);
        return ResultFactory.build(HttpCode.VALID,message);
    }


}
