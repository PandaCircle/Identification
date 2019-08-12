package com.hssw.springboot.test.springtest.Service.Key;

import java.security.Key;
import java.security.spec.KeySpec;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.springframework.stereotype.Component;


@Component
public class DesKey implements IKey {

    @Override
    public Key GetKey() {
        try{
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DES");

            KeySpec keySpec = new DESKeySpec(KeyMessage.GetKeyContent().getBytes());
            SecretKey key = secretKeyFactory.generateSecret(keySpec);
            return key;
        }
        catch(Exception e){

            e.getStackTrace();
            return null;
        }

    }    

}