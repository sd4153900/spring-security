package com.study.permission.web.response;

import com.study.permission.model.enums.HttpCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HttpResult<T> {

    private int code;
    private String message;
    private T data;

    public HttpResult(HttpCode httpCode,T data){
        this.code = httpCode.getCode();
        this.message = httpCode.getMessage();
        this.data = data;
    }

    public static <T> HttpResult<T> ok(T data){
        return new HttpResult<>(HttpCode.SUCCESS,data);
    }

    public static <T> HttpResult<T> error(T data){
        return new HttpResult<>(HttpCode.ERROR,data);
    }
}
