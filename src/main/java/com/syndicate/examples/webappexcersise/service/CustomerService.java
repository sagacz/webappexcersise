package com.syndicate.examples.webappexcersise.service;

import java.util.List;

import com.syndicate.examples.webappexcersise.domain.Customer;
import com.syndicate.examples.webappexcersise.domain.dto.CustomerDto;
import com.syndicate.examples.webappexcersise.repository.CustomerRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {
    
    private final CustomerRepository repository;

    public List<Customer> listCustomers(){
        return repository.findAll();
    }

    public Customer getCustomer(long id){
        return repository.findById(id).orElseThrow();
    }

    public Customer addCustomer(Customer customer){
        //customer.setId(null);
        return repository.save(customer);
    }

}
