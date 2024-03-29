package com.hssw.springboot.test.springtest.Controller;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import com.hssw.model.UserEntity;
import com.hssw.springboot.test.springtest.Exception.BusinessException;
import com.hssw.springboot.test.springtest.Results.BaseResult;
import com.hssw.springboot.test.springtest.Service.TokenService;
import com.hssw.springboot.test.springtest.Service.UserInfo;
import com.hssw.springboot.test.springtest.Service.UserService;
import com.hssw.springboot.test.springtest.Util.Redis.RedisStorage;
import com.hssw.springboot.test.springtest.Util.Security.CryptoManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Login 验证身份 -> 携带用户识别码重定向到
 * 
 */

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

    @RequestMapping(value ="/CheckToken", method = RequestMethod.GET)
    public Object CheckToken(String token)throws Exception{
        String encoded_sub = tokenService.ParseToken(token);
        CryptoManager cm = new CryptoManager();
        String sub = cm.UseDesProvider().decode(encoded_sub);
        return sub;
    }

    @RequestMapping(value = "/Login",method = RequestMethod.POST)
    public Object Login(UserEntity user,HttpServletResponse response)throws Exception{
        UserEntity validUser =  userService.validateUser(user.getUserName(), user.getPassword());
        //创建用户信息摘要
        UserInfo userInfo = new UserInfo();
        userInfo.UserName = validUser.getNickName();
        userInfo.Group = "amdin";
        String userSubject = JSON.toJSONString(userInfo); 

        //加密摘要
        CryptoManager cm = new CryptoManager();
        try{
            userSubject = cm.UseDesProvider().encode(userSubject);
        }
        catch(Exception e){
            throw new BusinessException(e.getMessage(),9001);
        }

        //创建用户token
        String userToken = null;
        userToken = tokenService.GenerateUserToken(userSubject, 240);

        //储存用户token
        RedisStorage.GetInstance().GetResource().setex(userToken, 4*60*60, String.valueOf(validUser.getId()));
        
        BaseResult result = new BaseResult();
        result.content.put("userInfo",userInfo);
        return result;
    }

}