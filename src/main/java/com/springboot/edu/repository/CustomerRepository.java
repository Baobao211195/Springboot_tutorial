package com.springboot.edu.repository;

import com.springboot.edu.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	List<Customer> getCustomerByBirthDateAndStatusOrderByBirthDateAsc();



}
