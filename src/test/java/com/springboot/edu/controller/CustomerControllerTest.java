package com.springboot.edu.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.edu.domain.Customer;
import com.springboot.edu.util.Status;
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

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

	@Autowired private ObjectMapper mapper;

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
	public void test_customer_can_be_create() throws Exception {
		Customer c1 = Customer.builder()
							.firstName("oanh")
							.lastName("pv")
							.status(Status.VIP)
							.birthDate(LocalDate.of(2018, 4, 10))
							.build();

		given(customerService.createCustomer(c1)).willReturn(c1);

		String json = mapper.writeValueAsString(c1);

		mockMvc.perform(post("/customers")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json(" {\n" +
						"    \"firstName\" : \"oanh\",\n" +
						"    \"lastName\" : \"pv\",\n" +
						"    \"status\" : \"VIP\",\n" +
						"    \"birthDate\" :\"2018-04-10\"\n"  +
						"  }"));

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
