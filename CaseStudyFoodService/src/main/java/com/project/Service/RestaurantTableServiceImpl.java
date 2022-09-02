package com.project.Service;

import com.project.Repository.RestaurantTableRepository;
import com.project.model.Restaurant_Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantTableServiceImpl implements RestaurantTableService {
    @Autowired
    private RestaurantTableRepository tableRepo;

    @Override
    public List<Restaurant_Table> getAllTables() {
        List<Restaurant_Table> tableList = tableRepo.findAll();
        return tableList;
    }

    @Override
    public Optional<Restaurant_Table> getTable(int tableId) {
        return tableRepo.findById(tableId);
    }

    @Override
    public void insertTable(Restaurant_Table t) {
        var insertEmp = tableRepo.findById(t.getTableId());
        if(!insertEmp.isPresent()){
            tableRepo.save(t);
        }

    }

    @Override
    public void updateTable(Restaurant_Table t, int tableId) {
        var upTable = tableRepo.findById(tableId);
        if (upTable.isPresent()) {
            Restaurant_Table newTable = upTable.get();
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
