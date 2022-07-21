package com.danielev86.customermicro.repository;

import com.danielev86.customermicro.repository.model.Customer;

import java.util.List;

public interface CustomCustomerRepository {

    public List<Customer> findCustomers(String firstName, String lastName, String email);

}
