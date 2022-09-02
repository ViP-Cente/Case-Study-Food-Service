package com.project.Repository;

import com.project.model.OrderFoods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderFoodsRepository extends JpaRepository<OrderFoods, Integer> {
}
