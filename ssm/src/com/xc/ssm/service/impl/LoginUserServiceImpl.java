package com.xc.ssm.service.impl;

import javax.annotation.Resource;





import org.springframework.stereotype.Service;

import com.xc.ssm.dao.VipMapper;
import com.xc.ssm.entity.Vip;
import com.xc.ssm.service.LoginUserService;
import com.xc.ssm.utils.PasswordMd5;
@Service
public class LoginUserServiceImpl implements LoginUserService {
	private VipMapper vipmapper;
	
	@Resource
	public void setVipmapper(VipMapper vipmapper) {
		this.vipmapper = vipmapper;
	}

	@Override
	public Vip LoginUser(String username, String password) {
		//密码加密验证
		PasswordMd5 passwordmd5 = new PasswordMd5();
		System.out.println("开始加密");
		String  userpass = passwordmd5.encryption(password);
		System.out.println("加密成功");
		
		return vipmapper.selectUser(username, userpass);	
	}

	

}
