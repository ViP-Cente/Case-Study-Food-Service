package com.project;

import com.project.Service.OrderService;
import com.project.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("order/orderList")
    List<Order> getAllOrders(){
        return orderService.listAllOrders();
    }
    @GetMapping("order/findOrder/{orderID}")
    Optional<Order> FindByOrderId(@PathVariable int orderID){
        return orderService.FindByOrderId(orderID);
    }

    @PostMapping("order/addOrder")
    Order addOrder(@RequestBody Order order){
        return orderService.addOrder(order);
    }

    @PutMapping("order/updateOrder")
    Order updateOrder(@RequestBody Order order){
        return orderService.updateOrder(order);
    }

    @DeleteMapping("order/deleteOrder/{orderID}")
    void deleteOrder(@PathVariable int orderID){
        orderService.deleteOrder(orderID);
    }

    @DeleteMapping("order/deleteAll")
    void deleteAllOrders(){
        orderService.deleteAllOrders();
    }
}
