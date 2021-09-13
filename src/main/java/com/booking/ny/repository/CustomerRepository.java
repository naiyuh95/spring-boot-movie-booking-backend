package com.booking.ny.repository;
import java.util.*;

import com.booking.ny.entity.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByCustomerName(String name);
    
    List<Customer> findAll();

}