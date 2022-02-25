package com.example.demo.thirdquestion;

public class Calender {
	String productId;
	Double quantity;
	
	public Calender() {
		super();
	}
	public Calender(String productId, Double quantity) {
		super();
		this.productId = productId;
		this.quantity = quantity;
	}
	public String getProductId() {
		return productId;
	}
	public Double getQuantity() {
		return quantity;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}


}
