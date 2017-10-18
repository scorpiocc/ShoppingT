package com.xc.ssm.service;

import java.util.List;

import com.xc.ssm.entity.OrderForm;

public interface OrderFormService {
	public List<String> selectByUserName(String username);
}
