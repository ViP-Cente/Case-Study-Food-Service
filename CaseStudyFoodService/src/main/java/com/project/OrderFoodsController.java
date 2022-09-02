package com.project;

import com.project.Service.OrderFoodService;
import com.project.model.OrderFoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/orderFoods")
public class OrderFoodsController {

    @Autowired
    OrderFoodService ofservice;

    @RequestMapping("getAllOrderFoods")
    public List<OrderFoods> getAllOrderFoods(){
        List<OrderFoods> sList = ofservice.getAllOrderFoods();
        return sList;
    }

    @RequestMapping("getOrderFood/{orderId}")
    public ResponseEntity<OrderFoods> getOrderFood(@PathVariable("orderId") Integer orderId) {
        Optional<OrderFoods> getEmp = ofservice.getOrderFood(orderId);
        if(getEmp.isEmpty()){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(getEmp.get());
    }

    @PostMapping("insertOrderFood")
    public ResponseEntity<OrderFoods> insertOrderFood(@RequestBody OrderFoods of) {
        ofservice.insertOrderFood(of);
        return new ResponseEntity("Inserted orderFood: " + of, HttpStatus.OK);
    }


    @PutMapping("updateOrderFood/{orderId}")
    public ResponseEntity<OrderFoods> updateOrderFood(@RequestBody OrderFoods of, @PathVariable("orderId") Integer orderId) {
        ofservice.updateOrderFood(orderId, of);
        return new ResponseEntity("Updated orderFood: " + of, HttpStatus.OK);
    }

    @DeleteMapping("{orderId}")
    public ResponseEntity<String> deleteOrderFood(@PathVariable("orderId") Integer orderId) {
        Optional<OrderFoods> delOrderFood = ofservice.getOrderFood(orderId);
        if(delOrderFood.isPresent()){
            ofservice.deleteOrderFood(delOrderFood.get().getOrder_id());
            return ResponseEntity.status(HttpStatus.OK).body("Deleted OrderFood");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }


    @DeleteMapping("/deleteAllOrderFood")
    public String deleteAllOrderFood() {
        ofservice.deleteAllOrderFood();
        return "Deleted all ordered foods";
    }
}
