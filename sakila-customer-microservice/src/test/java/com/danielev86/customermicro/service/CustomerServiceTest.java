package com.danielev86.customermicro.service;

import com.danielev86.customermicro.controller.dto.CustomerDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @Test
    public void getCustomersByFirstNameLastNameEmail(){
        List<CustomerDTO> customers = customerService.getCustomers("MARY", null, null);
        Assertions.assertTrue(customers.size() == 1);
    }

}
