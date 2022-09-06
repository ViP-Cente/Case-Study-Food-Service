package com.project;

import com.project.Service.OrderFoodService;
import com.project.model.Customer;
import com.project.model.OrderFoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/admin/orderFoods")
public class OrderFoodsController {

	@Autowired
	OrderFoodService ofservice;

	@RequestMapping("getAllOrderFoods")
	public ResponseEntity<List<OrderFoods>> getAllOrderFoods() {
		return new ResponseEntity <List<OrderFoods>> ((List<OrderFoods>) ofservice.getAllOrderFoods(), HttpStatus.OK);
	}

	@RequestMapping("getOrderFood/{orderId}/{foodId}")
	public ResponseEntity<?> getOrderFood(@PathVariable("orderId") Integer orderId, @PathVariable Integer foodId) {
		try {
			return new ResponseEntity<OrderFoods>(ofservice.getOrderFood(orderId, foodId), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>("Customer not found", HttpStatus.CONFLICT);
		}

	}

	@PostMapping("insertOrderFood")
	public ResponseEntity<?> insertOrderFood(@RequestBody OrderFoods of) {
		try {
			return new ResponseEntity<OrderFoods>(ofservice.insertOrderFood(of), HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<String>("Customer not found", HttpStatus.CONFLICT);
		}
	}

	@PutMapping("updateOrderFood/{orderId}/{foodId}")
	public ResponseEntity<?> updateOrderFood(@RequestBody OrderFoods of, @PathVariable("orderId") Integer orderId,
			@PathVariable Integer foodId) {
		try {
			return new ResponseEntity<OrderFoods>(ofservice.updateOrderFood(orderId, foodId, of), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>("Customer not found", HttpStatus.CONFLICT);
		}

	}

	@DeleteMapping("deleteOrderFood/{orderId}/{foodId}")
	public ResponseEntity<String> deleteOrderFood(@PathVariable("orderId") Integer orderId,
			@PathVariable Integer foodId) {
		try {
			ofservice.deleteOrderFood(orderId, foodId);
			return ResponseEntity.status(HttpStatus.OK).body("Deleted OrderFood");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		
	}

	@DeleteMapping("/deleteAllOrderFood")
	public String deleteAllOrderFood() {
		ofservice.deleteAllOrderFood();
		return "Deleted all ordered foods";
	}
}