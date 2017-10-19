package com.xc.ssm.service;

import java.util.List;


public interface OrderFormService {
	//查看用户订单
	public List<String> selectByUserName(String username);
}
