package com.project.Service;

import com.project.model.Food;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface FoodService {
    List<Food> getAllFoods();
    Optional<Food> FindByFoodId(int foodID);
    Food addFood(Food food);
    Food updatePFood(Food food);
    void deleteFood(int foodID);
    void deleteAllFoods();
}