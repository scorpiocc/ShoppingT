package com.xc.ssm.service;

import java.util.List;

import com.xc.ssm.entity.Commodity;
import com.xc.ssm.entity.Vip;

public interface LoginUserService {
	public Vip LoginUser(String username,String userpass);

}
