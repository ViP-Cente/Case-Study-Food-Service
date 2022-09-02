package com.project.Service;

import com.project.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OrderService {
    List<Order> listAllOrders();
    Optional<Order> FindByOrderId(int orderID);
    Order addOrder(Order order);
    Order updateOrder(Order order);
    void deleteOrder(int orderID);
    void deleteAllOrders();
}