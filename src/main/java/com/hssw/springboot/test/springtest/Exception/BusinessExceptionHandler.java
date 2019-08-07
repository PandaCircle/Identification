package com.hssw.springboot.test.springtest.Exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@ControllerAdvice
public class BusinessExceptionHandler {
    
    @ExceptionHandler(BusinessException.class)
    public ModelAndView ExceptionResultRender(IBaseException ex){
        ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
        mav.addObject("code", ex.getCode());
        mav.addObject("message", ex.getMessage());
        return mav;
    }
}