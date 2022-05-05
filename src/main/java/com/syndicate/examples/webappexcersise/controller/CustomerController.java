package com.syndicate.examples.webappexcersise.controller;

import java.util.List;
import com.syndicate.examples.webappexcersise.domain.Customer;
import com.syndicate.examples.webappexcersise.domain.dto.CustomerDto;
import com.syndicate.examples.webappexcersise.domain.dto.CustomerMapper;
import com.syndicate.examples.webappexcersise.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/webapp")
@RequiredArgsConstructor
@Slf4j
public class CustomerController {

    private final CustomerService customerService;
    
    @GetMapping("/customers")
    public String listCustomers(Model model){
        List<CustomerDto> customers;
        customers = CustomerMapper.customersToCustomersDtosMapper(customerService.listCustomers());
        model.addAttribute("customers", customers);
        return "customer_list";
    }

    @GetMapping("/customer")
    public String createCustomer(Model model){
        if (model.containsAttribute("customer") == false)
            model.addAttribute("customer", new CustomerDto());

        return "customer_form";
    }

    @PostMapping("/customer")
     public String addCustomer(@ModelAttribute CustomerDto customer){
        log.info("Customer info processing");
        log.info(customer.getFirstName());
        log.info(customer.getLastName());
        log.info(customer.getEmail());
        Customer cust = CustomerMapper.customerDtoToCustomerMapper(customer);
        customer = CustomerMapper.customerToCustomerDtoMapper(customerService.addCustomer(cust));
        return "redirect:/webapp/customer";
    }   
}
