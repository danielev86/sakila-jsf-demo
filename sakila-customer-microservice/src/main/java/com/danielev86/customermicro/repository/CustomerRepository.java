package com.danielev86.customermicro.repository;

import com.danielev86.customermicro.repository.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
