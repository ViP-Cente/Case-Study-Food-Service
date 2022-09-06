package com.project.Service;

import com.project.model.Order;

import org.springframework.stereotype.Service;
import org.aspectj.weaver.ast.Or;


import java.util.List;
import java.util.Optional;

@Service
public interface OrderService {
    List<Order> listAllOrders();
    Order findByOrderId(int orderID) throws Exception;
    Order addOrder(Order order) throws Exception;
    Order updateOrder(Order order) throws Exception;
    boolean deleteOrder(int orderID) throws Exception;
    void deleteAllOrders();
    void addCustomerToOrder(Integer orderID, Integer customerID) throws Exception;
}