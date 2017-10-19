package com.xc.ssm.service;


import com.xc.ssm.entity.Vip;

public interface LoginUserService {
	//登陆验证
	public Vip LoginUser(String username,String userpass);

}
