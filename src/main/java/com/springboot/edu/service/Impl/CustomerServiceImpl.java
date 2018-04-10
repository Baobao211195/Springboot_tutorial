package com.springboot.edu.service.Impl;

import com.springboot.edu.domain.Customer;
import com.springboot.edu.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService {
  @Override
  public List<Customer> findAllCustomers() {
    return Collections.emptyList();
  }
}
