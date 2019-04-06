package com.study.permission.web.exception;

import com.study.permission.model.enums.HttpCode;

public class WebException extends RuntimeException {

    private HttpCode code;

    public WebException() {
        super();
    }

    public WebException(HttpCode code) {
        this.code = code;
    }

    public WebException(HttpCode code,String message) {
        super(message);
        this.code = code;
    }

    public HttpCode getCode() {
        return code;
    }
}
