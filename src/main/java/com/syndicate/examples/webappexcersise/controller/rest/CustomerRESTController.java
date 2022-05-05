package com.syndicate.examples.webappexcersise.controller.rest;

import com.syndicate.examples.webappexcersise.domain.Customer;
import com.syndicate.examples.webappexcersise.service.CustomerService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/webapp/api")
@RequiredArgsConstructor
public class CustomerRESTController {
    
    private final CustomerService customerService;

    @GetMapping("/customer/{id}")
    public Customer getCustomer(@PathVariable long id){
        return customerService.getCustomer(id);
    }
}
