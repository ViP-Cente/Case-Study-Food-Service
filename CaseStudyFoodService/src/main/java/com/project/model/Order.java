package com.project.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="order")
@Entity

public class Order {
    @Id
    int orderID;
    float total_order_price;
    int tableID;

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public float getTotalOrderPrice() {
        return total_order_price;
    }

    public void setTotalOrderPrice(float totalOrderPrice) {
        this.total_order_price = totalOrderPrice;
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
                ", totalOrderPrice=" + total_order_price +
                ", tableID=" + tableID +
                '}';
    }
}