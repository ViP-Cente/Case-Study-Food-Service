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
    public OrderFoods getOrderFood(Integer orderId, Integer foodId) throws Exception {
    	OrderFoodsID ofID = new OrderFoodsID(orderId, foodId);
    	if(ofRepo.findById(ofID) == null) {
			System.out.println("Order with id = " + orderId + " with foodId = " + foodId + " could not be found");
			throw new Exception();
		}else {
			return ofRepo.findById(ofID).get();
		}
    }

    @Override
    public OrderFoods insertOrderFood(OrderFoods o) throws Exception {
    	OrderFoodsID ofID = new OrderFoodsID(o.getOrder_id(),o.getFood_id());
        Optional<OrderFoods> insertOrF = ofRepo.findById(ofID);
        if (!insertOrF.isPresent()) {
           return ofRepo.save(o);
        } else {
            throw new Exception();
        }

    }

    @Override
    public OrderFoods updateOrderFood(Integer orderId, Integer foodId, OrderFoods newOrderF) throws Exception {
        Optional<OrderFoods> upOrF = ofRepo.findById(new OrderFoodsID(orderId, foodId));
        if (upOrF.isPresent()) {
            OrderFoods ordF = upOrF.get();
            ordF.setOrder_id(newOrderF.getOrder_id());
            ordF.setFood_id(newOrderF.getFood_id());
            ordF.setQuantity(newOrderF.getQuantity());

            return ofRepo.save(ordF);
        } else {
           throw new Exception();
        }

    }

    @Override
    public void deleteOrderFood(Integer orderId, Integer foodId) throws Exception {
    	OrderFoodsID id = new OrderFoodsID(orderId, foodId);
    	if(ofRepo.findById(id).isEmpty()) {
			System.out.println("Order with id = " + orderId + " with foodId = " + foodId + " could not be found");
			throw new Exception();
		}else {
			ofRepo.deleteById(id);
		}
    }

    @Override
    public void deleteAllOrderFood() {
        ofRepo.deleteAll();
        System.out.println("All ordered foods have been deleted");
    }
}