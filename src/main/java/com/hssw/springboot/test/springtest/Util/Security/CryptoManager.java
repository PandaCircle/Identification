package com.hssw.springboot.test.springtest.Util.Security;

public class CryptoManager {
    
    private static final String key ="hiwangqi";

    private static final String iv = "wangmeil";

    public CryptoManager(){}


    public DesProvider UseDesProvider() throws Exception{

        return new DesProvider(key, iv);
    }
}