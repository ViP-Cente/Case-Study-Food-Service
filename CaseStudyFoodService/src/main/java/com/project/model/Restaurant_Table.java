package com.project.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="restaurant_table")
@Entity
public class Restaurant_Table {

    @Id
    int tableId;
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
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Restaurant_Table{" +
                "tableID=" + tableId + ", customerId=" + customerId + ", totalPrice=" + totalPrice + '}';
    }
}

