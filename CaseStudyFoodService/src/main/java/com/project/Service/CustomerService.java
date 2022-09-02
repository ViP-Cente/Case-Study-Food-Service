package com.project.Service;


import java.util.List;

import com.project.model.Customer;

public interface CustomerService {
	List<Customer> getAll();
	Customer getCustomerById(Integer id) throws Exception;
	boolean deleteCustomerById(Integer id) throws Exception;
	Customer updateCustomer(Integer id, Customer customer) throws Exception;
	Customer createCustomer(Customer customer) throws Exception;

