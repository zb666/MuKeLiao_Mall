package com.imooc.mall.exception;

public class UserLoginException extends RuntimeException {

    private String errorMsg;

    public UserLoginException(String message) {
        this.errorMsg = message;
    }
}
