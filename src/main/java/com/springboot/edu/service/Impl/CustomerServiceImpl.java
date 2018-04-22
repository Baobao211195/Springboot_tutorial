package com.springboot.edu.service.Impl;

import com.springboot.edu.domain.Customer;
import com.springboot.edu.exception.ResourcesNotFoundException;
import com.springboot.edu.repository.CustomerRepository;
import com.springboot.edu.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;


	public static List<Customer> customerList = new ArrayList<>();

	@Override
	public List<Customer> findAllCustomers() {
		return customerRepository.findAll();
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
						.orElseThrow(ResourcesNotFoundException::new);

		return c;
	}

	@Override
	public boolean deleteCustomer(Integer customerId) throws Exception {
		boolean deleteFlag = customerList.removeIf(c -> customerId.equals(c.getId()));
		if(!deleteFlag) {
			throw new ResourcesNotFoundException();
		}
		return deleteFlag;
	}

	@Override
	public Customer getCustomerById(Integer customerId) throws Exception {
		return customerList.stream().filter(e-> customerId.equals(e.getId()))
									.findFirst()
									.orElseThrow(ResourcesNotFoundException::new);
	}
}
