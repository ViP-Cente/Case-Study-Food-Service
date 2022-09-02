package com.project.Service;

import com.project.Repository.FoodRepository;
import com.project.model.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class FoodServiceImpl implements FoodService{

    @Autowired
    FoodRepository foodRepository;

    @Override
    public List<Food> getAllFoods() {
        List<Food> fList = foodRepository.findAll();
        return fList;
    }

    @Override
    public Optional<Food> FindByFoodId(int foodID) {
        if(foodRepository.existsById(foodID)){
            return foodRepository.findById(foodID);
        }
        else{
            System.out.println("Food does not exist.");
        }
        return null;
    }

    @Override
    public Food addFood(Food food) {
        return foodRepository.save(food);
    }

    @Override
    public Food updatePFood(Food food) {
        Food food1 = foodRepository.findById(food.getFoodID()).get();
        if(Objects.nonNull(food.getFoodID()) && !"".equals(food1.getFoodID())){
            food1.setFoodID(food.getFoodID());
        }
        if(Objects.nonNull(food.getFood_name()) && !"".equals(food1.getFood_name())){
            food1.setFood_name(food.getFood_name());
        }
        if(Objects.nonNull(food.getPrice()) && !"".equals(food1.getPrice())){
            food1.setPrice(food.getPrice());
        }
        return food1;
    }

    @Override
    public void deleteFood(int foodID) {
        if(foodRepository.existsById(foodID)){
            foodRepository.deleteById(foodID);
            System.out.println("Deleted "+ foodID);
        }
        else{
            System.out.println("Food could not be deleted.");
        }
    }

    @Override
    public void deleteAllFoods() {
        foodRepository.deleteAll();
        System.out.println("Deleted all foods.");
    }
}