package com.project.Repository;

import com.project.model.OrderFoods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderFoodsRepository extends JpaRepository<OrderFoods, Integer> {
}
