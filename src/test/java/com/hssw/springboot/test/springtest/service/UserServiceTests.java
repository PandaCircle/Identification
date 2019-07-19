package com.hssw.springboot.test.springtest.service;

import java.lang.reflect.Method;

import com.hssw.springboot.test.springtest.Service.UserService;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

public class UserServiceTests{

    Method method = null;

    @Before
    public void setUp() throws Exception{
        method = UserService.class.getDeclaredMethod("encryptPassword",String.class,String.class);
        method.setAccessible(true);
    }

    
    
}
