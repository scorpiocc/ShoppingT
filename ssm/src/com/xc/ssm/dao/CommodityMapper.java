package com.xc.ssm.dao;

import java.util.List;

import com.xc.ssm.entity.Commodity;

public interface CommodityMapper {
	//浏览商品
	List<Commodity> selectCommodity();
	//根据条件查找商品
	List<Commodity> selectCommodityByKey(String keyWord);
	
	
    
    
}