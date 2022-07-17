package com.danielev86.customermicro.repository.impl;

import com.danielev86.customermicro.repository.CustomCustomerRepository;
import com.danielev86.customermicro.repository.bean.GenericBean;
import com.danielev86.customermicro.repository.model.Customer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class CustomCustomerRepositoryImpl extends CommonRepository implements CustomCustomerRepository {

    @Autowired
    private EntityManager entityManager;

    public List<Customer> findCustomers(String firstName, String lastName, String email){
        List<Customer> customers = new ArrayList<>();
        List<GenericBean> parameters = new ArrayList<>();
        List<String> conditions = new ArrayList<>();
        StringBuilder sqlQuery = new StringBuilder("SELECT c FROM Customer c ");
        if (StringUtils.isNotEmpty(firstName)){
            conditions.add("c.firstName=:firstName");
            parameters.add(new GenericBean("firstName", firstName));
        }

        if (StringUtils.isNotEmpty(lastName)){
            conditions.add("c.lastName=:lastName");
            parameters.add(new GenericBean("lastName", lastName));
        }

        if (StringUtils.isNotEmpty(email)){
            conditions.add("c.email=:email");
            parameters.add(new GenericBean("email", email));
        }

        Query query = buildAndHQLQuery(entityManager,sqlQuery,conditions,parameters);
        customers = query.getResultList();
        return customers;
    }
}
