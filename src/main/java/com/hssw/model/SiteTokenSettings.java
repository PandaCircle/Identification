package com.hssw.model;

import java.sql.Timestamp;

public class SiteTokenSettings{

    private int id;
    private String domain;
    private String token;
    private Timestamp update_time;

    public int getId(){
        return this.id;
    }

    public String getDomain(){
        return this.domain;
    }

    public String getToken(){
        return this.token;
    }

    public Timestamp getUpdateTime(){
        return this.update_time;
    }

    public void setDomain(String domain){
        this.domain = domain;
    }

    public void setToken(String token){
        this.token = token;
    }

    public void setUpdateTime(long timeMills){
        this.update_time = new Timestamp(timeMills);
    }
}