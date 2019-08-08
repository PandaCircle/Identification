package com.hssw.springboot.test.springtest.Util.Security;

public class CryptoManager {
    
    private static final String key ="hellowangqi";

    private static final String iv = "weare7";

    public CryptoManager(){}


    public DesProvider UseDesProvider() throws Exception{

        return new DesProvider(key, iv);
    }
}