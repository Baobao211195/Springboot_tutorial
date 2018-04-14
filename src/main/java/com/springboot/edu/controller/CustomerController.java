package com.springboot.edu.controller;

import com.springboot.edu.domain.Customer;
import com.springboot.edu.domain.Status;
import com.springboot.edu.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController(value = "/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping
	public List<Customer> getAllCustomers() {
		return customerService.findAllCustomers();

	}

	@PostMapping()
	public Customer createCustomer (@Valid @RequestBody Customer customer) {
		try {
			return customerService.createCustomer(customer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Customer();
	}

	@PutMapping(value = "/{customerId}")
	public Customer updateCustomer(@RequestBody Customer customer, @PathVariable Integer customerId) {
		try {
			return customerService.updateCustomer(customer, customerId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Customer();
	}

	@DeleteMapping(value = "/customerId")
	public boolean deleteCustomer(@PathVariable Integer customerId) throws Exception {
		try {
			return customerService.deleteCustomer(customerId);
		} catch (Exception e) {
			return false;
		}
	}

	@GetMapping(value = "/customerId")
	public Customer getCustomerById(@PathVariable Integer customerId) {
		try {
			return customerService.getCustomerById(customerId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


}
