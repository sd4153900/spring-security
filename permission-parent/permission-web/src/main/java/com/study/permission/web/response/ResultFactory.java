package com.study.permission.web.response;

import com.study.permission.model.enums.HttpCode;

public class ResultFactory {

    public static <T> HttpResult<T> build(HttpCode httpCode,T data){
        return new HttpResult<>(httpCode,data);
    }

    public static <T> HttpResult<T> ok(T data){
        return new HttpResult<>(HttpCode.SUCCESS,data);
    }

    public static <T> HttpResult<T> error(T data){
        return new HttpResult<>(HttpCode.ERROR,data);
    }
}
