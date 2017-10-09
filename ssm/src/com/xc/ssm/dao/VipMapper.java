package com.xc.ssm.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.xc.ssm.entity.Vip;
@Repository
public interface VipMapper {
    Vip selectUser(@Param("username")String username,@Param("userpass")String userpass);  //验证帐号
    
  
}