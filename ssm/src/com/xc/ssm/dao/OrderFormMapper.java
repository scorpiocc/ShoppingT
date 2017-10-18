package com.xc.ssm.dao;

import java.util.List;

import com.xc.ssm.entity.OrderForm;

public interface OrderFormMapper {
	
	int insertOrderForm(OrderForm record);
	
	List<String> selectByUserName(String username);
	
  /*  int deleteByPrimaryKey(Long id);

    int insert(OrderForm record);

    OrderForm selectByPrimaryKey(Long id);*/


}