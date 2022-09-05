package com.project.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Repository.CustomerRepository;
import com.project.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository repo;

	@Override
	public List<Customer> getAll() {
		List<Customer> cList= repo.findAll();
		return cList;
	}

	@Override
	public Customer getCustomerById(Integer id) throws Exception {
		if(repo.findById(id).isEmpty()) {
			System.out.println("Customer with id = " + id + " was not found");
			throw new Exception();
		}else {
			return repo.findById(id).get();
		}
	}

	@Override
	public boolean deleteCustomerById(Integer id) throws Exception {
		if(repo.findById(id).isEmpty()) {
			System.out.println("Customer with id = " + id + " was not found and could not be deleted");
			throw new Exception();
		}else {
			repo.deleteById(id);
			return true;
		}
	}

	@Override
	public Customer updateCustomer(Integer id, Customer customer) throws Exception {
		if(repo.findById(id).isEmpty()) {
			System.out.println("Customer with id = " + id + " was not found and could not be updated");
			throw new Exception();
		}else {
			Customer saved = repo.save(customer);
			return saved;
		}
	}

	@Override
	public Customer createCustomer(Customer customer) throws Exception {
		if(repo.existsById(customer.getCustomerID())) {
			throw new Exception();
		}
		Customer saved = repo.save(customer);
		return saved;
	}


}