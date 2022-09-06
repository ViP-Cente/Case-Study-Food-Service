package com.project;

import com.project.Service.RestaurantTableService;
import com.project.model.Restaurant_Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RestaurantTableController {

    @Autowired
    RestaurantTableService tableService;

    @RequestMapping("/admin/getAllTables")
    @ResponseBody
    public List<Restaurant_Table> getAllTables(){
        List<Restaurant_Table> tableList = tableService.getAllTables();
        return tableList;
    }

    @RequestMapping("/getTable/{tableId}")
    @ResponseBody
    public ResponseEntity<Restaurant_Table> getTable(@PathVariable("tableId") Integer tableId) {
        Optional<Restaurant_Table> getTable = tableService.getTable(tableId);
        if(getTable.isEmpty()){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(getTable.get());
    }

    @PostMapping("/insertTable")
    public ResponseEntity<Restaurant_Table> insertTable(@RequestBody Restaurant_Table t) {
        tableService.insertTable(t);
        return new ResponseEntity("Inserted new entity: " + t, HttpStatus.OK);
    }


    @PutMapping("/updateTable/{tableId}")
    public ResponseEntity<Restaurant_Table> updateTable(@RequestBody Restaurant_Table t, @PathVariable("tableId") Integer tableId) {
        tableService.updateTable(t, tableId);
        return new ResponseEntity("Table has been updated: " + t, HttpStatus.OK);
    }

    @DeleteMapping("/{tableId}")
    public ResponseEntity<String> deleteTable(@PathVariable("tableId") Integer tableId) {
        Optional<Restaurant_Table> deleteTable = tableService.getTable(tableId);
        if(deleteTable.isPresent()){
            tableService.deleteTable(tableId);
            return ResponseEntity.status(HttpStatus.OK).body("Table has been deleted");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }


    @DeleteMapping("/deleteAllTables")
    public String deleteAll() {
        tableService.deleteAllTables();
        return "Deleted all tables from the database";
    }
}
