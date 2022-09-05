package com.project.Service;

import com.project.model.OrderFoods;
import com.project.model.OrderFoodsID;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface OrderFoodService {

    List<OrderFoods> getAllOrderFoods();
    Optional<OrderFoods> getOrderFood(Integer orderId, Integer foodId) throws Exception;
    void insertOrderFood(OrderFoods o) throws Exception;
    void updateOrderFood(Integer orderId, Integer foodId, OrderFoods orderFoodUpdate) throws Exception;
    void deleteOrderFood(Integer orderId, Integer foodId) throws Exception;
    void deleteAllOrderFood();
}
