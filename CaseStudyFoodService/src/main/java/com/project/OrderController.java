package com.project;

import com.project.Service.OrderService;
import com.project.model.Customer;
import com.project.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping("/hello")
	public String hello() {
		return "Hello world";
	}
    
    @GetMapping("orderList")
    ResponseEntity<List<Order>> getAllOrders(){
    	return new ResponseEntity <List<Order>> ((List<Order>) orderService.listAllOrders(), HttpStatus.OK);
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

    @DeleteMapping("deleteAll")
    void deleteAllOrders(){
        orderService.deleteAllOrders();
    }
}