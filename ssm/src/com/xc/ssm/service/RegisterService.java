package com.xc.ssm.service;

import com.xc.ssm.entity.Register;
import com.xc.ssm.entity.Vip;

public interface RegisterService {
	//添加用户
	public int insertVip(Register register);
	//修改用户	
	public int updataVip(Vip vip);
	//根据名字查找用户
	public Vip selectByUser(String username);

}
