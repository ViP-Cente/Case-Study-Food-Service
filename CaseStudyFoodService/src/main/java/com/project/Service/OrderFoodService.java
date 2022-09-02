package com.project.Service;

import com.project.model.OrderFoods;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OrderFoodService {

    List<OrderFoods> getAllOrderFoods();
    Optional<OrderFoods> getOrderFood(int orderId);
    void insertOrderFood(OrderFoods o);
    void updateOrderFood(int orderId, OrderFoods orderFoodUpdate);
    void deleteOrderFood(int orderId);
    void deleteAllOrderFood();
}
