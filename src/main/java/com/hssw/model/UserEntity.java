package com.hssw.model;

public class UserEntity {
    
    private int id;
    private String nickName;
    private String password;
    private String userName;

    public int getId(){
        return this.id;
    }

    public String getNickName(){
        return this.nickName;
    }

    public void setNickName(String nickname){
        this.nickName = nickname;
    }

    public String getPassword(){
        return this.password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getUserName(){
        return this.userName;
    }

    public void setUserName(String username){
        this.userName = username;
    }
}