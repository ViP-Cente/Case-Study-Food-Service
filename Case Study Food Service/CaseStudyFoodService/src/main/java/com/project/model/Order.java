package com.project.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="order")
@Entity

public class Order {
    @Id
    int orderID;
    float totalOrderPrice;
    int tableID;

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public float getTotalOrderPrice() {
        return totalOrderPrice;
    }

    public void setTotalOrderPrice(float totalOrderPrice) {
        this.totalOrderPrice = totalOrderPrice;
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
                ", totalOrderPrice=" + totalOrderPrice +
                ", tableID=" + tableID +
                '}';
    }
}
