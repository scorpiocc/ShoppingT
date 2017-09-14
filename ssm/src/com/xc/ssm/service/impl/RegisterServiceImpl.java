package com.xc.ssm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xc.ssm.dao.RegisterMapper;
import com.xc.ssm.entity.Register;
import com.xc.ssm.service.RegisterService;
@Service
public class RegisterServiceImpl implements RegisterService{
	private RegisterMapper registermapper;
	@Resource
	public void setRegistermapper(RegisterMapper registermapper) {
		this.registermapper = registermapper;
	}

	@Override
	public int insertVip(Register register) {
		return registermapper.insertSelective(register);
	}

}
