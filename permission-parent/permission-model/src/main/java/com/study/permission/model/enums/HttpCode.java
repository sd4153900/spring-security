package com.study.permission.model.enums;

public enum HttpCode {
    SUCCESS(200,"success"),
    FAIL(700,"请求失败"),
    UNKONW(701,"未知错误")
    ;

    private int code;
    private String message;

    HttpCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
