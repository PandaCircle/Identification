package com.hssw.springboot.test.springtest.Exception;

public enum BusinessExceptions {

    // 业务异常描述
    USER_VALIDATE_FAILED(10001,"用户凭证无效"),
    USER_TOKEN_INVAILD(10002,"用户TOKEN验证不通过");

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