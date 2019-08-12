package com.hssw.springboot.test.springtest.Results;

import java.util.HashMap;
import java.util.Map;

public class BaseResult {

    public BaseResult(){
        this.content = new HashMap<>();
    }

    public String Status = "Success";

    public String Code = "0";

    public Map<String,Object> content;


}