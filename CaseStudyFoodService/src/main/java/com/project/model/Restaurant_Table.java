package com.project.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="restaurant_table")
@Entity
public class Restaurant_Table {

    @Id
    Integer table_id;
    float total_price;

    public int getTable_id() {
        return table_id;
    }

    public void setTable_id(Integer tableId) {
        this.table_id = tableId;
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
                "tableID=" + table_id + ", totalPrice=" + total_price + '}';

    }
}

