package com.springboot.edu.service;

import com.springboot.edu.domain.Customer;

import java.util.List;

public interface CustomerService {

	List<Customer> findAllCustomers();

	Customer createCustomer(Customer customer) throws Exception;

	Customer updateCustomer(Customer customer, Integer customerId) throws Exception;

	boolean deleteCustomer(Integer customerId) throws Exception;

	Customer getCustomerById(Integer customerId) throws Exception;
}
