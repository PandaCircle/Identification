package com.hssw.springboot.test.springtest.Service;

import java.util.Random;

import com.hssw.mapper.UserMapper;

import com.hssw.model.UserEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void createUser(String username , String nickname, String password){
        UserEntity user = new UserEntity();
        user.setNickName(nickname);
        user.setUserName(username);
        String salt = salt();
        user.setPassword(passwordWithSalt(encryptPassword(password, salt),salt));
        userMapper.insert(user);
    }

    public String ShowMePwd(){
        UserEntity user = userMapper.getUserByUserName("14407840210");
        return user.getPassword();
    }

    public boolean checkUserPwd(UserEntity user , String password){
        
        String pws = user.getPassword();
        String salt = getSaltFromPws(pws);
        String pwd_salt = encryptPassword(password, salt);
        pwd_salt = passwordWithSalt(pwd_salt, salt);

        return pws.equals(pwd_salt);

    }

    public UserEntity validateUser(String userName, String password){
        UserEntity user = userMapper.getUserByUserName(userName);
        if(user == null)
            return null;
        if(checkUserPwd(user, password)){
            return user;
        }
        else
            return null;
    }

    private String encryptPassword(String password, String salt){
        String meterial = password + salt;
        String encryptStr = DigestUtils.md5DigestAsHex(meterial.getBytes());
        return encryptStr;
    }

    private static char[] hex = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};

    //生成随机盐
    private String salt(){
        Random random = new Random();
        StringBuilder salt = new StringBuilder();
        for(int i =0;i<salt.capacity();i++){
            salt.append(hex[random.nextInt(16)]);
        }
        return salt.toString();
    }


    //密码加盐存储
    private String passwordWithSalt(String password , String salt){
        char[] salt_m = new char[16];
        for(int i =0;i<16;i++){
            salt_m[i] = salt.charAt((i+4)%16);
        } 
        return password+String.valueOf(salt_m);
    }

    //根据储存提取盐
    private String getSaltFromPws(String pws){
        String salt_m = pws.substring(32, 48);
        char[] salt = new char[16];
        for(int i=0;i<16;i++){
            salt[i] = salt_m.charAt((i+12)%16);
        }
        return String.valueOf(salt);
    }

    //账户摘要信息
    public String userSummary(int id){
        UserEntity user = userMapper.getUserById(id);
        if(user == null)
            return null;
        String summary = user.getId() +'|'+ user.getUserName() +'|'+ user.getNickName();
        return summary;
    }
}