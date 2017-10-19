package com.xc.ssm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xc.ssm.dao.CommodityMapper;
import com.xc.ssm.entity.Commodity;
import com.xc.ssm.service.ShoppingService;
@Service
public class ShoppingServiceImpl implements ShoppingService {
	private CommodityMapper commoditymapper;
	@Resource
	public void setCommoditymapper(CommodityMapper commoditymapper) {
		this.commoditymapper = commoditymapper;
	}

	@Override
	public List<Commodity> selectCommodity() {
		return commoditymapper.selectCommodity(); 
	}

	@Override
	public List<Commodity> selectCommodityByKey(String KeyWord) {
		return commoditymapper.selectCommodityByKey(KeyWord);
	}

}
 