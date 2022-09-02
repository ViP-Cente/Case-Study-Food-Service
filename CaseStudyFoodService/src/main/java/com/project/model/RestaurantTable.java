package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="restaurant_table")
@Entity
public class RestaurantTable {

    @Id
    int tableId;
    float total_Price;
    int customerId;
    float totalPrice;

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public float getTotalPrice() {
        return total_Price;
    }

    public void setTotalPrice(float totalPrice) {
        this.total_Price = totalPrice;
    }

    @Override
    public String toString() {
        return "Restaurant_Table{" +
                "tableID=" + tableId + ", totalPrice=" + total_Price + '}';

    }
}
