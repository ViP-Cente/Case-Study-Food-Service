package com.project.Service;

import com.project.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> listAllOrders();
    Optional<Order> FindByOrderId(int orderID);
    Order addOrder(Order order);
    Order updateOrder(Order order);
    void deleteOrder(int orderID);
    void deleteAllOrders();
}