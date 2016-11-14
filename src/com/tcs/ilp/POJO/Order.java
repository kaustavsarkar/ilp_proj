package com.tcs.ilp.POJO;

import java.sql.Timestamp;

public class Order {
	
	private int orderNo;
	private Timestamp currentTimestamp;
	private int itemId;
	private double quantity;
	private double amount;
	private int outletId;
	private int customerId;
	
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public Timestamp getCurrentTimestamp() {
		return currentTimestamp;
	}
	public void setCurrentTimestamp(Timestamp date) {
		this.currentTimestamp = date;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getOutletId() {
		return outletId;
	}
	public void setOutletId(int outletId) {
		this.outletId = outletId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	

}
