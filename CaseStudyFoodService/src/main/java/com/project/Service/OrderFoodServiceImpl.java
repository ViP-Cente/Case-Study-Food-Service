package com.project.Service;

import com.project.Repository.OrderFoodsRepository;
import com.project.model.OrderFoods;
import com.project.model.OrderFoodsID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderFoodServiceImpl implements OrderFoodService {

    @Autowired
    private OrderFoodsRepository ofRepo;

    @Override
    public List<OrderFoods> getAllOrderFoods() {
        List<OrderFoods> ofList = ofRepo.findAll();
        return ofList;
    }

    @Override
    public Optional<OrderFoods> getOrderFood(Integer orderId, Integer foodId) {
        return ofRepo.findById(new OrderFoodsID(orderId, foodId));
    }

    @Override
    public void insertOrderFood(OrderFoods o) throws Exception {
    	OrderFoodsID ofID = new OrderFoodsID(o.getOrder_id(),o.getFood_id());
        Optional<OrderFoods> insertOrF = ofRepo.findById(ofID);
        if (!insertOrF.isPresent()) {
            ofRepo.save(o);
        } else {
            throw new Exception();
        }

    }

    @Override
    public void updateOrderFood(Integer orderId, Integer foodId, OrderFoods newOrderF) throws Exception {
        Optional<OrderFoods> upOrF = ofRepo.findById(new OrderFoodsID(orderId, foodId));
        if (upOrF.isPresent()) {
            OrderFoods ordF = upOrF.get();
            ordF.setOrder_id(newOrderF.getOrder_id());
            ordF.setFood_id(newOrderF.getFood_id());
            ordF.setQuantity(newOrderF.getQuantity());

            ofRepo.save(ordF);
        } else {
           throw new Exception();
        }

    }

    @Override
    public void deleteOrderFood(Integer orderId, Integer foodId) {
        ofRepo.deleteById(new OrderFoodsID(orderId, foodId));
        System.out.println("Food ordered has been deleted");
    }

    @Override
    public void deleteAllOrderFood() {
        ofRepo.deleteAll();
        System.out.println("All ordered foods have been deleted");
    }
}