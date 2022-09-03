package com.project.Repository;

import com.project.model.Restaurant_Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantTableRepository extends JpaRepository<Restaurant_Table, Integer> {
}
