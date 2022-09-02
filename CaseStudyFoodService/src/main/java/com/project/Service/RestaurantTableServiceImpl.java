package com.project.Service;

import com.project.Repository.RestaurantTableRepository;
import com.project.model.RestaurantTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantTableServiceImpl implements RestaurantTableService {
    @Autowired
    private RestaurantTableRepository tableRepo;

    @Override
    public List<RestaurantTable> getAllTables() {
        List<RestaurantTable> tableList = tableRepo.findAll();
        return tableList;
    }

    @Override
    public Optional<RestaurantTable> getTable(int tableId) {
        return tableRepo.findById(tableId);
    }

    @Override
    public void insertTable(RestaurantTable t) {
        var insertEmp = tableRepo.findById(t.getTableId());
        if(!insertEmp.isPresent()){
            tableRepo.save(t);
        }

    }

    @Override
    public void updateTable(RestaurantTable t, int tableId) {
        var upTable = tableRepo.findById(tableId);
        if (upTable.isPresent()) {
            RestaurantTable newTable = upTable.get();
            newTable.setTableId(t.getTableId());
            newTable.setCustomerId(t.getCustomerId());
            newTable.setTotalPrice(t.getTotalPrice());

            tableRepo.save(newTable);
        } else {
            System.out.println("Entity did not update succesfully");
        }
    }


    @Override
    public void deleteTable(int tableId){
        tableRepo.deleteById(tableId);
        System.out.println("Table deleted");
    }

    @Override
    public void deleteAllTables(){
        tableRepo.deleteAll();
        System.out.println("All restaurant tables deleted from the database");
    }

}
