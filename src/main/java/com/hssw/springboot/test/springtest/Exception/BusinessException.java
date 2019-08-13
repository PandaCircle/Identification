package com.hssw.springboot.test.springtest.Exception;

public class BusinessException extends RuntimeException implements IBaseException {

    private static final long serialVersionUID = 1L;

    private int errCode;

    private Exception causeException = null;
    
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

    public BusinessException(Exception from , BusinessExceptions dispatch){
        super(dispatch.getMessage());
        this.causeException = from;
        this.errCode = dispatch.getCode();
    }

    @Override
    public int getCode() {
        return this.errCode;
    }

}
