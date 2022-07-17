package com.danielev86.customermicro.repository;

import com.danielev86.customermicro.repository.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
