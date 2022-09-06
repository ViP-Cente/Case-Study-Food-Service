package com.project;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Service.CustomerService;
import com.project.model.Customer;


@RestController
@RequestMapping(path = "/admin/customers")
public class CustomerController {

	@Autowired
	CustomerService service;

	@GetMapping("/")
	public String home() {
		return("<h1>Welcome</h1>");
	}

	@GetMapping("/show")
	public ResponseEntity<List<Customer>> getAllCustomers(){
		return new ResponseEntity <List<Customer>> ((List<Customer>) service.getAll(), HttpStatus.OK);
	}

	@GetMapping("/getCustomer/{id}")
	public ResponseEntity<?> getDepartmentById(@PathVariable Integer id) throws Exception{
		try {
			return new ResponseEntity<Customer>(service.getCustomerById(id), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>("Customer not found", HttpStatus.CONFLICT);
		}
	}

	@DeleteMapping("/deleteCustomer/{id}")
	public ResponseEntity<?> deleteDepartmentById(@PathVariable Integer id) throws Exception{
		try {
			return new ResponseEntity<Boolean>(service.deleteCustomerById(id), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>("Customer not found", HttpStatus.CONFLICT);
		}
	}

	@PostMapping("/createCustomer")
	public ResponseEntity<?> createCustomer(@RequestBody Customer cust) throws Exception{
		try {
			return new ResponseEntity<Customer>(service.createCustomer(cust), HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<String>("Customer not found", HttpStatus.CONFLICT);
		}
	}

	@PutMapping("/updateCustomer/{id}")
	public ResponseEntity<?> updateDepartment(@PathVariable Integer id, @RequestBody Customer cust) throws Exception{
		try {
			return new ResponseEntity<Customer>(service.updateCustomer(id, cust), HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<String>("Customer not found", HttpStatus.CONFLICT);
		}
	}
}