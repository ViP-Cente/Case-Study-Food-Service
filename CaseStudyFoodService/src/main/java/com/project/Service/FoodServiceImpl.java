package com.project.Service;

import com.project.Repository.FoodRepository;
import com.project.model.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
    public Food findByFoodId(int foodID)throws Exception {
        if(foodRepository.existsById(foodID)){
            return foodRepository.findById(foodID).get();
        }
        else{
            System.out.println("Food does not exist.");
            throw new Exception();
        }
    }

    @Override
    public Food addFood(Food food) throws Exception {
        if(!foodRepository.existsById(food.getFoodID())){
            return foodRepository.save(food);

        }
        else{
            throw new Exception();
        }

    }

    @Override
    public Food updateFood(Food food) throws Exception {
        if(foodRepository.findById(food.getFoodID()).isEmpty()){
            throw new Exception();
        }
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
        return foodRepository.save(food1);
    }

    @Override
    public boolean deleteFood(int foodID) throws Exception {
        if(foodRepository.existsById(foodID)){
            foodRepository.deleteById(foodID);
            System.out.println("Deleted "+ foodID);
            return true;
        }
        else{
            System.out.println("Food could not be deleted.");
            throw new Exception();

        }
    }

    @Override
    public void deleteAllFoods() {
        foodRepository.deleteAll();
        System.out.println("Deleted all foods.");
    }
}