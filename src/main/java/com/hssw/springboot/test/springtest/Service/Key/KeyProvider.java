package com.hssw.springboot.test.springtest.Service.Key;

import java.security.Key;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KeyProvider {

    @Autowired
    private IKey key;

    public Key GetKey(){
        return key.GetKey();
    }
    
}