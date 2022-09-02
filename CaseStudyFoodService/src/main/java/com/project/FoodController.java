package com.project;

import com.project.Service.FoodService;
import com.project.model.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FoodController {
    @Autowired
    FoodService foodService;

    @GetMapping("/food/foodList")
    public List<Food> listAllFoods(){
        return foodService.getAllFoods();
    }
    @GetMapping("/food/findFood/{foodID}")
    Optional<Food> FindByFoodId(@PathVariable int foodID){
        return foodService.FindByFoodId(foodID);
    }

    @PostMapping("/food/addFood")
    Food addFood(@RequestBody Food food){
        return foodService.addFood(food);
    }

    @PutMapping("/food/updateFood")
    Food updatePFood(@RequestBody Food food){
        return foodService.updatePFood(food);
    }

    @DeleteMapping("/food/deleteFood/{foodID}")
    void deleteFood(@PathVariable int foodID){
        foodService.deleteFood(foodID);
    }
    @DeleteMapping("/food/deleteAll")
    void deleteAllFoods(){
        foodService.deleteAllFoods();
    }
}