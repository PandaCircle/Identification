package com.hssw.springboot.test.springtest.Exception;

public enum BusinessExceptions {

    // 业务异常描述
    USER_VALIDATE_FAILED(10001,"用户凭证无效"),
    CALL_ERROR(90001,"程序错误");

    private String message;

    private int errCode;

    private BusinessExceptions(int errCode, String message){
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