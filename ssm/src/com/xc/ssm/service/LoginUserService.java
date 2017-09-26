package com.xc.ssm.service;

import com.xc.ssm.entity.Vip;

public interface LoginUserService {
	public Vip LoginUser(String username,String userpass);
}
