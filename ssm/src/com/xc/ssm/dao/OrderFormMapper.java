package com.xc.ssm.dao;

import java.util.List;

import com.xc.ssm.entity.OrderForm;

public interface OrderFormMapper {
	
	//根据用户查看订单
	List<String> selectByUserName(String username);
	//增加订单记录
	int insertOrderForm(OrderForm record);
	
  /*  int deleteByPrimaryKey(Long id);

    int insert(OrderForm record);

    OrderForm selectByPrimaryKey(Long id);*/


}