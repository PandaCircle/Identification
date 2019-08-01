package com.hssw.exception;

public class BussinessException extends RuntimeException implements IBaseException {

    private static final long serialVersionUID = 1L;

    private int errCode;
    
    public BussinessException(){
        super();
    }

    public BussinessException(String message, int errCode){
        super(message);
        this.errCode = errCode;
    }

    @Override
    public int getCode() {
        return this.errCode;
    }

    
}