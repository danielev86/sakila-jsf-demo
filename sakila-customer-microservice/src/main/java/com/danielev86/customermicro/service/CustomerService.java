package com.danielev86.customermicro.service;

import com.danielev86.customermicro.repository.CustomerRepository;
import com.danielev86.customermicro.repository.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerService extends AbstractService {

    @Autowired
    private CustomerRepository customerRepository;

    public void getCustomers(String firstName, String lastName, String email){
        List<Customer> customers = customerRepository.findCustomers(firstName,lastName,email);
    }

}
