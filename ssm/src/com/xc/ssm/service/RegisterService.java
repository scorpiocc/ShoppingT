package com.xc.ssm.service;

import com.xc.ssm.entity.Register;
import com.xc.ssm.entity.Vip;

public interface RegisterService {
	public int insertVip(Register register);
	
	public int updataVip(Vip vip);
	
	public Vip selectByUser(String username);

}
