package com.hssw.springboot.test.springtest.Service;

import java.security.Key;

public interface ITokenService {

    Key GetKey(String screct);
    
}