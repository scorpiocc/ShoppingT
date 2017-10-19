package com.xc.ssm.dao;

import com.xc.ssm.entity.Register;
import com.xc.ssm.entity.Vip;

public interface RegisterMapper {
	//注册用户
	int insertSelective(Register register);
	//修改用户信息
	int updateByPrimaryKeySelective(Vip vip);
	//根据名字查找用户
	Vip selectByUser(String username);
	
}
