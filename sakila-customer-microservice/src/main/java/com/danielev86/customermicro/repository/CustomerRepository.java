package com.danielev86.customermicro.repository;

import com.danielev86.customermicro.repository.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>, CustomCustomerRepository {

    public List<Customer> findByStoreId(Long storeId);

    public List<Customer> findAllByOrderByFirstNameAscLastNameAsc();

}
