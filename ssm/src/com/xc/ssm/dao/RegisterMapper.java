package com.xc.ssm.dao;

import com.xc.ssm.entity.Register;

public interface RegisterMapper {
	int insertSelective(Register register);
	
}
