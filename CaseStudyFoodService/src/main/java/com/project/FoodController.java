package com.project;

import com.project.Service.FoodService;
import com.project.model.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodController {
    @Autowired
    FoodService foodService;

    @GetMapping("/food/foodList")
    public ResponseEntity<List<Food>> listAllFoods(){
        return new ResponseEntity <List<Food>> ((List<Food>) foodService.getAllFoods(), HttpStatus.OK);
    }
    @GetMapping("/food/findFood/{foodID}")
    public ResponseEntity<?> FindByFoodId(@PathVariable int foodID) throws Exception {
        try {
            return new ResponseEntity<Food>(foodService.findByFoodId(foodID), HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<String>("Food not found", HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/food/addFood")
    public ResponseEntity<?> addFood(@RequestBody Food food) throws Exception {
        try {
            return new ResponseEntity<Food>(foodService.addFood(food), HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<String>("Food not found", HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/food/updateFood")
    public ResponseEntity<?> updateFood(@RequestBody Food food) throws Exception {
        try {
            return new ResponseEntity<Food>(foodService.updateFood(food), HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<String>("Food not found", HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/food/deleteFood/{foodID}")
    public ResponseEntity<?> deleteFood(@PathVariable int foodID) throws Exception {
        try {
            return new ResponseEntity<Boolean>(foodService.deleteFood(foodID), HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<String>("Food not found", HttpStatus.CONFLICT);
        }
    }
    @DeleteMapping("/food/deleteAll")
    void deleteAllFoods(){
        foodService.deleteAllFoods();
    }
}