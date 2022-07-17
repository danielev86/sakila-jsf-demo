package com.danielev86.customermicro.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AddressRepositoryTest {

    private static final Logger logger = LoggerFactory.getLogger(AddressRepositoryTest.class);

    @Autowired
    private AddressRepository addressRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void findAllAddress(){
       long numOfElement = addressRepository.count();
        Assertions.assertTrue(numOfElement == 603L);
    }
}
