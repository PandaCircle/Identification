package com.hssw.springboot.test.springtest.Controller;

import com.hssw.model.UserEntity;
import com.hssw.springboot.test.springtest.Service.TokenService;
import com.hssw.springboot.test.springtest.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
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
        UserEntity user = userService.validateUser("14407840210", "123456");
        return user != null;
    }

    @RequestMapping("/Login")
    public String Login(){
        UserEntity user = userService.validateUser("14407840210", "12346");
        if(user == null){
            return "Login Failed due to incorrect login information";
        }
        String userSummary = userService.userSummary(user.getId());
        return tokenService.GenerateUserToken("hssw", 1, userSummary, 1000);

    }
}