package com.xc.ssm.service;

import java.util.List;

import com.xc.ssm.entity.Commodity;

public interface ShoppingService {
	//浏览商品
	public List<Commodity> selectCommodity();
	
	//根据查找搜索商品
	public List<Commodity> selectCommodityByKey(String KeyWord);
	
}
