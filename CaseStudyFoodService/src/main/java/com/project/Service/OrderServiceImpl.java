package com.project.Service;

import com.project.Repository.OrderRepository;
import com.project.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Order> listAllOrders() {
        List<Order> oList = orderRepository.findAll();
        return oList;
    }

    @Override
    public Optional<Order> FindByOrderId(int orderID) {
        if(orderRepository.existsById(orderID)){
            return orderRepository.findById(orderID);
        }
        else{
            System.out.println("Order does not exist.");
        }
        return null;
    }

    @Override
    public Order addOrder(Order order) {
        if(!orderRepository.existsById(order.getOrderID())){
            return orderRepository.save(order);
        }
        else{
            System.out.println("This order already exists.");
        }
        return order;
    }

    @Override
    public Order updateOrder(Order order) {
        Order order1 = orderRepository.findById(order.getOrderID()).get();
        if(Objects.nonNull(order.getOrderID()) && !"".equals(order1.getOrderID())) {
            order1.setOrderID(order.getOrderID());
        }
        if(Objects.nonNull(order.getTotalPrice()) && !"".equals(order1.getTotalPrice())) {
            order1.setTotalPrice(order1.getTotalPrice());
        }
        if(Objects.nonNull(order.getTableID()) && !"".equals(order1.getTableID())) {
            order1.setTableID(order.getTableID());
        }

        return orderRepository.save(order1);
    }

    @Override
    public void deleteOrder(int orderID) {
        if(orderRepository.existsById(orderID)){
            orderRepository.deleteById(orderID);
            System.out.println("Deleted "+ orderID);
        }
        else{
            System.out.println("Order could not be deleted.");
        }
    }

    @Override
    public void deleteAllOrders() {
        orderRepository.deleteAll();
        System.out.println("Deleted all orders");
    }
}