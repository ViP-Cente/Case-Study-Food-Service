package com.project.Service;

import com.project.model.RestaurantTable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface RestaurantTableService {

    List<RestaurantTable> getAllTables();
    Optional<RestaurantTable> getTable(int tableId);
    void insertTable(RestaurantTable t);
    void updateTable(RestaurantTable t, int tableId);
    void deleteTable(int tableId);
    void deleteAllTables();
}

