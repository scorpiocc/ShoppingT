package com.xc.ssm.service;

import java.util.List;

import com.xc.ssm.entity.OrderForm;


public interface OrderFormService {
	//查看用户订单
	public List<String> selectByUserName(String username);
	//增加订单记录
	public int insertOrderForm(OrderForm orderform);
}
