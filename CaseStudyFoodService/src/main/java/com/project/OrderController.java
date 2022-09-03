package com.project;

import com.project.Service.OrderService;
import com.project.model.Customer;
import com.project.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<?> getAllOrders(){
        return new ResponseEntity<List<Order>>((List<Order>)orderService.listAllOrders(), HttpStatus.OK);

    }
    @GetMapping("findOrder/{orderID}")
    public ResponseEntity<?> findByOrderId(@PathVariable int orderID) throws Exception {
        try{
            return new ResponseEntity<Order>(orderService.findByOrderId(orderID), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>("Order not found", HttpStatus.CONFLICT);
        }
    }

    @PostMapping("addOrder")
    public ResponseEntity<?> addOrder(@RequestBody Order order) throws Exception {
        try{
            return new ResponseEntity<Order>(orderService.addOrder(order), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>("Order could not be created", HttpStatus.CONFLICT);
        }

    }

    @PutMapping("updateOrder")
    public ResponseEntity<?> updateOrder(@RequestBody Order order) throws Exception {
        try{
            return new ResponseEntity<Order>(orderService.updateOrder(order), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>("Order could not be updated", HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("deleteOrder/{orderID}")
    public ResponseEntity<?> deleteOrder(@PathVariable int orderID)throws Exception {
        try{
            return new ResponseEntity<Boolean>(orderService.deleteOrder(orderID), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>("Order could not be deleted", HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("deleteAll")
    public void deleteAllOrders(){
        orderService.deleteAllOrders();
    }
}