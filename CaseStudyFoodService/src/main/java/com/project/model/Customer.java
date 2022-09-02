package com.project.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Customer {

	@Id
	Integer customerID;
	String customer_first_name;
	String customer_last_name;
	String paymentMethod;
	Integer tableID;

	public Customer() {

	}

	public Customer(Integer customerID, String customer_first_name, String customerLastName, String paymentMethod,
					Integer tableID) {
		super();
		this.customerID = customerID;
		this.customer_first_name = customer_first_name;
		this.customer_last_name = customerLastName;
		this.paymentMethod = paymentMethod;
		this.tableID = tableID;
	}

	public Integer getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}

	public String getCustomer_first_name() {
		return customer_first_name;
	}

	public void setCustomer_first_name(String customer_first_name) {
		this.customer_first_name = customer_first_name;
	}

	public String getCustomer_last_name() {
		return customer_last_name;
	}

	public void setCustomer_last_name(String customer_last_name) {
		this.customer_last_name = customer_last_name;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Integer getTableID() {
		return tableID;
	}

	public void setTableID(Integer tableID) {
		this.tableID = tableID;
	}

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", customerFirstName=" + customer_first_name + ", customerLastName="
				+ customer_last_name + ", paymentMethod=" + paymentMethod + ", tableID=" + tableID + "]";
	}
}
	
