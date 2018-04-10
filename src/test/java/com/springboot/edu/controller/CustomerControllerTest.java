package com.springboot.edu.controller;

import com.springboot.edu.domain.Customer;
import com.springboot.edu.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;

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
    customer.
  }

}
