package com.hssw.springboot.test.springtest.Exception;

public interface IBaseException {
    
    //返回错误信息
    String getMessage();

    //返回错误代码
    int getCode();
}