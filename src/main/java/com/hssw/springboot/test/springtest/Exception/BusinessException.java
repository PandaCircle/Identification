package com.hssw.springboot.test.springtest.Exception;

public class BusinessException extends RuntimeException implements IBaseException {

    private static final long serialVersionUID = 1L;

    private int errCode;
    
    public BusinessException(){
        super();
    }

    public BusinessException(String message, int errCode){
        super(message);
        this.errCode = errCode;
    }

    public BusinessException(BusinessExceptions ex){
        super(ex.getMessage());
        this.errCode = ex.getCode();
    }

    @Override
    public int getCode() {
        return this.errCode;
    }

}
