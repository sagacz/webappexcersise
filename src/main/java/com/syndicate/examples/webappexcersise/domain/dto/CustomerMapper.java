package com.syndicate.examples.webappexcersise.domain.dto;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.syndicate.examples.webappexcersise.domain.Customer;

public class CustomerMapper {

    public static CustomerDto customerToCustomerDtoMapper(Customer customer){
        return new CustomerDto(customer.getId(), customer.getFirstName(),
                    customer.getLastName(), customer.getEmail());

    }
    
    public static Customer customerDtoToCustomerMapper(CustomerDto cdto){
        return new Customer(cdto.getId(), cdto.getFirstName(), 
                    cdto.getLastName(), cdto.getEmail());
    }

    public static List<CustomerDto> customersToCustomersDtosMapper(List<Customer> customers){
        return customers.stream()
                .map(c -> new CustomerDto(
                        c.getId(),
                        c.getFirstName(),
                        c.getLastName(),
                        c.getEmail()))
                .collect(Collectors.toList());
    }

    
}
