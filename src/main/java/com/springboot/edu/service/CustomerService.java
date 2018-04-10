package com.springboot.edu.service;

import com.springboot.edu.domain.Customer;

import java.util.List;

public interface CustomerService {

  public List<Customer> findAllCustomers();
}
