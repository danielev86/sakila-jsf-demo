package com.danielev86.customermicro.controller;

import com.danielev86.customermicro.controller.dto.CustomerDTO;
import com.danielev86.customermicro.service.CustomerService;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/customer")
public class CustomerController{

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers(){
        logger.info("Call service to retrieve all customers");
        List<CustomerDTO> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/customer-by-firstname-lastname-email")
    public ResponseEntity<List<CustomerDTO>> getCustomers(@RequestParam("firstName") String firstName
            , @RequestParam("lastName") String lastName
            , @RequestParam("email") String email){
        logger.info("Call service to retrieve customers by firstName or lastName or email");
        List<CustomerDTO> customers = customerService.getCustomers(firstName,lastName,email);
        if (CollectionUtils.isNotEmpty(customers)){
            return new ResponseEntity<>(customers, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/store")
    public ResponseEntity<List<CustomerDTO>> getCustomerInStore(@RequestParam("storeId") Long storeId){
        logger.info("Call service to retrieve customers in store");
        List<CustomerDTO> customers = customerService.getCustomersInStore(storeId);
        if (CollectionUtils.isNotEmpty(customers)){
            return new ResponseEntity<>(customers, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
