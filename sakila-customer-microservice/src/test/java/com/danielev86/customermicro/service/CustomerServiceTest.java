package com.danielev86.customermicro.service;

import com.danielev86.customermicro.controller.dto.CustomerDTO;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class CustomerServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceTest.class);
    @Autowired
    private CustomerService customerService;

    @Test
    public void getCustomersByFirstNameLastNameEmailTest(){
        List<CustomerDTO> customers = customerService.getCustomers("MARY", null, null);
        Assertions.assertTrue(customers.size() == 1);
        printLogCustomers(customers);
    }

    @Test
    public void getAllCustomerTest(){
        List<CustomerDTO> customers = customerService.getAllCustomers();
        Assertions.assertTrue(CollectionUtils.isNotEmpty(customers));
        printLogCustomers(customers);
    }

    @Test
    public void getCustomersByStoreTest(){
        List<CustomerDTO> customers = customerService.getCustomersInStore(1L);
        Assertions.assertTrue(customers.size() > 0);
        printLogCustomers(customers);
        customers = customerService.getCustomersInStore(4L);
        Assertions.assertNull(customers);
    }

    @Test
    public void getCustomerByIdTest(){
        CustomerDTO customer = customerService.getCustomerByID(1L);
        Assertions.assertNotNull(customer);
        printLogCustomers(Arrays.asList(customer));
        customer = customerService.getCustomerByID(5000L);
        Assertions.assertNull(customer);
    }

    private void printLogCustomers(List<CustomerDTO> customers){
        if (CollectionUtils.isNotEmpty(customers)){
            customers.forEach(customer -> logger.info("Print customer info: "+ customer.toString()));
        }
    }
}
