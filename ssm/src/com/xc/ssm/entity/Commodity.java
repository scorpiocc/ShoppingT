package com.xc.ssm.entity;

import java.math.BigDecimal;

public class Commodity {
    private String commodityNumber;

    private String commodityName;

    private String commodityMade;

    private BigDecimal commodityPrice;

    private Integer commodityBalance;

    private String commodityPic;

    private Long commodityId;


	public String getCommodityNumber() {
        return commodityNumber;
    }

    public void setCommodityNumber(String commodityNumber) {
        this.commodityNumber = commodityNumber == null ? null : commodityNumber.trim();
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName == null ? null : commodityName.trim();
    }

    public String getCommodityMade() {
        return commodityMade;
    }

    public void setCommodityMade(String commodityMade) {
        this.commodityMade = commodityMade == null ? null : commodityMade.trim();
    }

    public BigDecimal getCommodityPrice() {
        return commodityPrice;
    }

    public void setCommodityPrice(BigDecimal commodityPrice) {
        this.commodityPrice = commodityPrice;
    }

    public Integer getCommodityBalance() {
        return commodityBalance;
    }

    public void setCommodityBalance(Integer commodityBalance) {
        this.commodityBalance = commodityBalance;
    }

    public String getCommodityPic() {
        return commodityPic;
    }

    public void setCommodityPic(String commodityPic) {
        this.commodityPic = commodityPic == null ? null : commodityPic.trim();
    }

    public Long getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Long commodityId) {
        this.commodityId = commodityId;
    }

	@Override
	public String toString() {
		return "Commodity [commodityNumber=" + commodityNumber
				+ ", commodityName=" + commodityName + ", commodityMade="
				+ commodityMade + ", commodityPrice=" + commodityPrice
				+ ", commodityBalance=" + commodityBalance + ", commodityPic="
				+ commodityPic + ", commodityId=" + commodityId + "]";
	}
}