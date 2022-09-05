package com.project.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "orderfoods")
@IdClass(OrderFoodsID.class)
public class OrderFoods implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -6601307318619358601L;
	@Id
    Integer order_id;
    @Id
    Integer food_id;
    Integer quantity;
    
    public OrderFoods() {
    	
    }

    public OrderFoods(Integer order_id, Integer food_id, Integer quantity) {
		super();
		this.order_id = order_id;
		this.food_id = food_id;
		this.quantity = quantity;
	}

	public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public int getFood_id() {
        return food_id;
    }

    public void setFood_id(Integer food_id) {
        this.food_id = food_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderFoods{" +
                "orderId=" + order_id + ", foodId=" + food_id + ", quantity=" + quantity + '}';
    }
}