package com.hssw.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Configuration
@AutoConfigureBefore
public class GlobalExceptionHandler implements HandlerExceptionResolver,Ordered {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
            Exception ex) {
        logger.info(ex.getMessage());
        ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
        if(ex instanceof BussinessException){
            IBaseException bex = (BussinessException)ex;
            mav.addObject("message", bex.getMessage());
            mav.addObject("code", bex.getCode());
        }
        else{
            mav.addObject("handler", handler);
            mav.addObject("message", ex.getMessage());
        }
        
        return mav;
    }

    @Override
    public int getOrder() {
        return 0;
    }
    
}