package com.springboot.edu.service.Impl;

import com.springboot.edu.domain.Customer;
import com.springboot.edu.service.CustomerService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;


@Service
public class CustomerServiceImpl implements CustomerService {

	public static List<Customer> customerList = new ArrayList<>();

	@Override
	public List<Customer> findAllCustomers() {
		return Collections.emptyList();
	}

	@Override
	public Customer createCustomer(Customer customer) throws Exception {
		customer.setId(Integer.parseInt(UUID.randomUUID().toString()));
		customerList.add(customer);
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer, Integer customerId) throws Exception {
		Customer c = customerList.stream()
						.filter(e -> customerId.equals(e.getId()))
				        .map(e -> {
				        	e.setId(customerId);
				        	e.setStatus(customer.getStatus());
				        	e.setLastName(customer.getLastName());
				        	e.setFirstName(customer.getFirstName());
				        	e.setBirthDate(customer.getBirthDate());
				        	return e;
				        })
						.findFirst()
						.orElseThrow(() -> new SQLException("Update is unsuccessful!"));

		return c;
	}

	@Override
	public boolean deleteCustomer(Integer customerId) throws Exception {
		boolean deleteFlag = customerList.removeIf(c -> customerId.equals(c.getId()));
		if(!deleteFlag) {
			throw new SQLException("Delete is unsuccessful !");
		}
		return deleteFlag;
	}

	@Override
	public Customer getCustomerById(Integer customerId) throws Exception {
		return customerList.stream().filter(e-> customerId.equals(e.getId()))
									.findFirst()
									.orElseThrow(() -> new SQLException("Not found resources!"));
	}
}
