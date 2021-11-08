package com.infosys.user.entity;

import java.io.Serializable;

public class BuyerProductId implements Serializable {
	private String buyerId;
	private String productId;
	public String getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
}
