package com.project.Service;

import com.project.Repository.OrderFoodsRepository;
import com.project.model.OrderFoods;
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
    public Optional<OrderFoods> getOrderFood(int orderId) {
        return ofRepo.findById(orderId);
    }

    @Override
    public void insertOrderFood(OrderFoods o) {
        var insertOrF = ofRepo.findById(o.getOrder_id());
        if (!insertOrF.isPresent()) {
            ofRepo.save(o);
        } else {
            System.out.println("Food order already exists. Entity not added");
        }

    }

    @Override
    public void updateOrderFood(int orderId, OrderFoods newOrderF) {
        var upOrF = ofRepo.findById(orderId);
        if (upOrF.isPresent()) {
            OrderFoods ordF = upOrF.get();
            ordF.setOrder_id(newOrderF.getOrder_id());
            ordF.setFood_id(newOrderF.getFood_id());
            ordF.setQuantity(newOrderF.getQuantity());

            ofRepo.save(ordF);
        } else {
            System.out.println("orderId cannot be found. Cannot be updated");
        }

    }

    @Override
    public void deleteOrderFood(int orderId) {
        ofRepo.deleteById(orderId);
        System.out.println("Food ordered has been deleted");
    }

    @Override
    public void deleteAllOrderFood() {
        ofRepo.deleteAll();
        System.out.println("All ordered foods have been deleted");
    }
}