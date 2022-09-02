package com.project;

import com.project.Service.OrderService;
import com.project.model.Moderator;
import com.project.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("order/orderList")
    public ResponseEntity<?> getAllOrders(){
        return new ResponseEntity<List<Order>>((List<Order>)orderService.listAllOrders(), HttpStatus.OK);
//        return orderService.listAllOrders();
    }
    @GetMapping("order/findOrder/{orderID}")
    public ResponseEntity<?> findByOrderId(@PathVariable int orderID) throws Exception {
        try{
            return new ResponseEntity<Order>(orderService.findByOrderId(orderID), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>("Order not found", HttpStatus.CONFLICT);
        }
//        return orderService.findByOrderId(orderID);
    }

    @PostMapping("order/addOrder")
    public ResponseEntity<?> addOrder(@RequestBody Order order) throws Exception {
        try{
            return new ResponseEntity<Order>(orderService.addOrder(order), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>("Order could not be created", HttpStatus.CONFLICT);
        }
//        return orderService.addOrder(order);
    }

    @PutMapping("order/updateOrder")
    public ResponseEntity<?> updateOrder(@RequestBody Order order) throws Exception {
        try{
            return new ResponseEntity<Order>(orderService.updateOrder(order), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>("Order could not be updated", HttpStatus.CONFLICT);
        }
//        return orderService.updateOrder(order);
    }

    @DeleteMapping("order/deleteOrder/{orderID}")
    public ResponseEntity<?> deleteOrder(@PathVariable int orderID)throws Exception {
        try{
            return new ResponseEntity<Boolean>(orderService.deleteOrder(orderID), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>("Order could not be deleted", HttpStatus.CONFLICT);
        }
//        orderService.deleteOrder(orderID);
    }

    @DeleteMapping("order/deleteAll")
    public void deleteAllOrders(){
        orderService.deleteAllOrders();
    }
}