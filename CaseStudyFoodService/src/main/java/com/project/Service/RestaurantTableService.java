package com.project.Service;

import com.project.model.Restaurant_Table;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface RestaurantTableService {

    List<Restaurant_Table> getAllTables();
    Optional<Restaurant_Table> getTable(int tableId);
    void insertTable(Restaurant_Table t);
    void updateTable(Restaurant_Table t, int tableId);
    void deleteTable(int tableId);
    void deleteAllTables();
}

