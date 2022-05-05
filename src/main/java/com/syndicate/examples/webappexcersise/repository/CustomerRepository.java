package com.syndicate.examples.webappexcersise.repository;

import com.syndicate.examples.webappexcersise.domain.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
}
