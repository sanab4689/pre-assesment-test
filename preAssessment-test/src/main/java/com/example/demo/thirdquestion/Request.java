package com.example.demo.thirdquestion;

public class Request {
	private String productId ;
	private int availability;
	
	public Request() {
		super();
	}
	public Request(String productId, int availability) {
		super();
		this.productId = productId;
		this.availability = availability;
	}
	public String getProductId() {
		return productId;
	}
	public int getAvailability() {
		return availability;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public void setAvailability(int availability) {
		this.availability = availability;
	}

}
