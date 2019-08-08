package com.hssw.springboot.test.springtest.Controller;

import com.alibaba.fastjson.JSONObject;
import com.hssw.model.UserEntity;
import com.hssw.springboot.test.springtest.Service.TokenService;
import com.hssw.springboot.test.springtest.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController{

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @RequestMapping("Hello")
    public String Index() {
        return "Hello";
    }

    @RequestMapping("/Show")
    public String Show(){
        userService.createUser("14407840210", "lihaofei", "123456");
        return userService.ShowMePwd();
    }

    @RequestMapping("/Check")
    public boolean Check(){
        UserEntity user = userService.validateUser("14407840210", "12456");
        return user != null;
    }

    @RequestMapping(value = "/Login",method = RequestMethod.POST)
    public Object Login(UserEntity user){
        UserEntity validUser =  userService.validateUser(user.getUserName(), user.getPassword());
        JSONObject ob = new JSONObject();
        ob.put("id",validUser.getId());
        ob.put("username", validUser.getNickName());
        return ob.toJSONString();
    }
}