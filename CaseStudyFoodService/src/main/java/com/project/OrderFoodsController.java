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
	public List<OrderFoods> getAllOrderFoods() {
		List<OrderFoods> sList = ofservice.getAllOrderFoods();
		System.out.println(sList);
		return sList;
	}

	@RequestMapping("getOrderFood/{orderId}/{foodId}")
	public ResponseEntity<?> getOrderFood(@PathVariable("orderId") Integer orderId, @PathVariable Integer foodId) {
		Optional<OrderFoods> getEmp;
		try {
			getEmp = ofservice.getOrderFood(orderId, foodId);
			return ResponseEntity.status(HttpStatus.OK).body(getEmp.get());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<String>("OrderFood not found", HttpStatus.CONFLICT);
		}

	}

	@PostMapping("insertOrderFood")
	public ResponseEntity<OrderFoods> insertOrderFood(@RequestBody OrderFoods of) {
		try {
			ofservice.insertOrderFood(of);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity("Inserted orderFood: " + of, HttpStatus.OK);
	}

	@PutMapping("updateOrderFood/{orderId}/{foodId}")
	public ResponseEntity<?> updateOrderFood(@RequestBody OrderFoods of, @PathVariable("orderId") Integer orderId,
			@PathVariable Integer foodId) {
		try {
			ofservice.updateOrderFood(orderId, foodId, of);
			return new ResponseEntity("Updated orderFood: " + of, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<String>("OrderFood not found", HttpStatus.CONFLICT);
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