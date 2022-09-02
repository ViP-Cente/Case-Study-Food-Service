package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="order")
@Entity
public class Order {
    @Id
    Integer orderID;
    
    @Column(name = "totalPrice")
    Float totalPrice;
    
    Integer tableID;

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getTableID() {
        return tableID;
    }

    public void setTableID(int tableID) {
        this.tableID = tableID;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", totalOrderPrice=" + totalPrice +
                ", tableID=" + tableID +
                '}';
    }
}