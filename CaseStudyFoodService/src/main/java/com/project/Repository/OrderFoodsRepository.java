package com.project.Repository;

import com.project.model.OrderFoods;
import com.project.model.OrderFoodsID;

import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderFoodsRepository extends JpaRepository<OrderFoods, OrderFoodsID> {
}
