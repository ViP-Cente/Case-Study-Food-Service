package com.project.Service;

import com.project.Repository.OrderRepository;
import com.project.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
    public Order findByOrderId(int orderID) throws Exception {
        if(orderRepository.existsById(orderID)){
            return orderRepository.findById(orderID).get();
        }
        else{
            System.out.println("This order could not be updated.");
            throw new Exception();
        }
    }

    @Override
    public Order addOrder(Order order) throws Exception {
        if(!orderRepository.existsById(order.getOrderID())){
            return orderRepository.save(order);
        }
        else{
            System.out.println("This order already exists.");
            throw new Exception();
        }

    }

    @Override
    public Order updateOrder(Order order) throws Exception {
        if(orderRepository.findById(order.getOrderID()).isEmpty()){
            System.out.println("This does not order exist.");
            throw new Exception();
        }
        Order order1 = orderRepository.findById(order.getOrderID()).get();
        if(Objects.nonNull(order.getOrderID()) && !"".equals(order1.getOrderID())) {
            order1.setOrderID(order.getOrderID());
        }
        if(Objects.nonNull(order.getTotal_price()) && !"".equals(order1.getTotal_price())) {
            order1.setTotal_price(order1.getTotal_price());
        }
        if(Objects.nonNull(order.getTableID()) && !"".equals(order1.getTableID())) {
            order1.setTableID(order.getTableID());
        }

        return orderRepository.save(order1);
    }

    @Override
    public boolean deleteOrder(int orderID) throws Exception {
        if(orderRepository.existsById(orderID)){
            orderRepository.deleteById(orderID);
            System.out.println("Deleted "+ orderID);
            return true;
        }
        else{
            System.out.println("Order could not be deleted.");
            throw new Exception();
        }
    }

    @Override
    public void deleteAllOrders() {
        orderRepository.deleteAll();
        System.out.println("Deleted all orders");
    }
}