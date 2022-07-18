package com.danielev86.customermicro.repository;

import com.danielev86.customermicro.repository.model.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CustomerRepositoryTest {
    private static final Logger logger = LoggerFactory.getLogger(CustomerRepositoryTest.class);

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void findById(){
        Customer customer = customerRepository.findById(1L).get();
        Assertions.assertTrue("MARY".equalsIgnoreCase(customer.getFirstName()));
        Assertions.assertTrue("SMITH".equalsIgnoreCase(customer.getLastName()));
    }

    @Test
    public void findByFirstNameAndLastNameAndEmail(){
        List<Customer> customers = customerRepository.findCustomers("MARY",null, null);
        Assertions.assertTrue(customers.size() == 1);
        customers = customerRepository.findCustomers("MARY","SMITH", null);
        Assertions.assertTrue(customers.size() == 1);
    }
}
