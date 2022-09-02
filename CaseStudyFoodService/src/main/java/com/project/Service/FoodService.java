package com.project.Service;

import com.project.model.Food;

import java.util.List;

public interface FoodService {
    List<Food> getAllFoods();
    Food findByFoodId(int foodID)throws Exception;
    Food addFood(Food food)throws Exception;
    Food updateFood(Food food)throws Exception;
    boolean deleteFood(int foodID)throws Exception;
    void deleteAllFoods();
}