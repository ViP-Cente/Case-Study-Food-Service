package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="receipt")
@Entity

public class Order {
    @Id
    int orderID;

    @Column(name = "totalPrice")
    Float total_price;

    Integer tableID;

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public float getTotalOrderPrice() {
        return total_price;
    }

    public void setTotalOrderPrice(float totalOrderPrice) {
        this.total_price = totalOrderPrice;
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
                ", totalOrderPrice=" + total_price +
                ", tableID=" + tableID +
                '}';
    }
}