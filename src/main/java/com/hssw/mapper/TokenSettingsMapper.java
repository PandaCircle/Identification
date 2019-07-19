package com.hssw.mapper;

import java.util.List;

import com.hssw.model.SiteTokenSettings;

import org.apache.ibatis.annotations.Select;

public interface TokenSettingsMapper{

    @Select("SELECT * FROM site_token_settings")
    List<SiteTokenSettings> getAll();


}