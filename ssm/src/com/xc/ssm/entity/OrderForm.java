package com.xc.ssm.entity;

import java.math.BigDecimal;
import java.util.Date;

public class OrderForm {
    private Long id;

    private String username;

    private Date orderdate;

    private String commodityName;

    private BigDecimal commodityPrice;

    private Long sum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName == null ? null : commodityName.trim();
    }

    public BigDecimal getCommodityPrice() {
        return commodityPrice;
    }

    public void setCommodityPrice(BigDecimal commodityPrice) {
        this.commodityPrice = commodityPrice;
    }

    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }

	@Override
	public String toString() {
		return "OrderForm [id=" + id + ", username=" + username
				+ ", orderdate=" + orderdate + ", commodityName="
				+ commodityName + ", commodityPrice=" + commodityPrice
				+ ", sum=" + sum + "]";
	}
    
}