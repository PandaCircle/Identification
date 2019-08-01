package com.hssw.exception;

public interface IBaseException {
    
    //返回错误信息
    String getMessage();

    //返回错误代码
    int getCode();
}