package com.xc.ssm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xc.ssm.dao.OrderFormMapper;
import com.xc.ssm.entity.OrderForm;
import com.xc.ssm.service.OrderFormService;
@Service
public class OrderFormServiceImpl implements OrderFormService {
	private OrderFormMapper orderformmapper;
	
	@Resource
	public void setOrderformmapper(OrderFormMapper orderformmapper) {
		this.orderformmapper = orderformmapper;
	}

	//根据ID浏览订单
	@Override
	public List<String> selectByUserName(String username) {
		return orderformmapper.selectByUserName(username);
	}

	@Override
	public int insertOrderForm(OrderForm orderform) {
		return orderformmapper.insertOrderForm(orderform);
	}

}
