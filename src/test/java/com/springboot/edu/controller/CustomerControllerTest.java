package com.springboot.edu.controller;

import com.springboot.edu.domain.Customer;
import com.springboot.edu.domain.Status;
import com.springboot.edu.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CustomerController.class)
public class CustomerControllerTest {

	@MockBean
	private CustomerService customerService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void test_customer_can_be_serialized_correctly() throws Exception {
		Customer customer = new Customer();
		customer.setBirthDate(LocalDate.of(2018, 4, 10));
		customer.setFirstName("pv");
		customer.setLastName("oanh");
		customer.setStatus(Status.VIP);

		given(customerService.findAllCustomers()).willReturn(Arrays.asList(customer));
		mockMvc.perform(get("/customers")
				.accept(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk())
				.andExpect(content().json("[\n" +
						"  {\n" +
						"    \"firstName\" : \"pv\",\n" +
						"    \"lastName\" : \"oanh\",\n" +
						"    \"status\" : \"VIP\",\n" +
						"    \"birthDate\" :\"2018-04-10\"\n" +
						"  }\n" +
						"]\n"));
	}

	@Test
	public void createCustomer() throws Exception {
	}

	@Test
	public void updateCustomer() throws Exception {
	}

	@Test
	public void deleteCustomer() throws Exception {
	}

	@Test
	public void getCustomerById() throws Exception {
	}

}
