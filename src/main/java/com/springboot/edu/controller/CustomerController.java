package com.springboot.edu.controller;

import com.springboot.edu.domain.Customer;
import com.springboot.edu.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value="/customers")
public class CustomerController {

  @Autowired
  private CustomerService customerService;

  @GetMapping
  public List<Customer> getAllCustomers() {
    return customerService.findAllCustomers();
  }
}
