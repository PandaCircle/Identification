package com.hssw.exception;

public enum BussinessExceptions {

    // 业务异常描述
    USER_VALIDATE_FAILED(10001,"用户凭证无效");

    private String message;

    private int errCode;

    private BussinessExceptions(int errCode, String message){
        this.message = message;
        this.errCode = errCode;
    }

    public String getMessage(){
        return this.message;
    }

    public int getCode(){
        return this.errCode;
    }
}