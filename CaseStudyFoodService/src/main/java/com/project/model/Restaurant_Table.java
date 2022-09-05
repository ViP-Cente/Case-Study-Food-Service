package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="restaurant_table")
@Entity
public class Restaurant_Table {

    @Id
    @Column(name="tableId")
    int tableId;
    float total_price;

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public float getTotal_price() {
        return total_price;
    }

    public void setTotal_price(float total_price) {
        this.total_price = total_price;
    }

    @Override
    public String toString() {
        return "Restaurant_Table{" +
                "tableID=" + tableId + ", totalPrice=" + total_price + '}';

    }
}

