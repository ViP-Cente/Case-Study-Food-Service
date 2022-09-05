package com.project.model;

import java.io.Serializable;

public class OrderFoodsID implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2210271565970999064L;
	/**
	 * 
	 */
	
	
	private Integer order_id;
	private Integer food_id;
	
	public OrderFoodsID() {
		
	}
	public OrderFoodsID(Integer orderID, Integer foodID) {
		super();
		this.order_id = orderID;
		this.food_id= foodID;
	}
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	public Integer getFood_id() {
		return food_id;
	}
	public void setFood_id(Integer food_id) {
		this.food_id = food_id;
	}
	
	
	
	
}
