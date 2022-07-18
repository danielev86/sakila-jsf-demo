package com.danielev86.customermicro.service;

import com.danielev86.customermicro.controller.dto.CustomerDTO;
import com.danielev86.customermicro.repository.CustomerRepository;
import com.danielev86.customermicro.repository.model.Customer;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService extends AbstractService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerDTO> getCustomers(String firstName, String lastName, String email){
        List<Customer> customers = customerRepository.findCustomers(firstName,lastName,email);
        List<CustomerDTO> customersDTO = CollectionUtils.isNotEmpty(customers)
                ? (List<CustomerDTO>) getConverter().convert(customers
                , TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(Customer.class))
                , TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(CustomerDTO.class)))
                : null;
        return customersDTO;
    }

}
