package com.galvanize.customer.controllers;

import com.galvanize.customer.entities.Customer;
import com.galvanize.customer.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/*
Http Requests are handled by the controller
 */
@RestController
@Transactional
public class CustomerRestController {

    /*
    We are using Spring Autowiring to wire the Customer service into the CustomerRestController
     */
    @Autowired
    CustomerService customerService;

    /*
    Mapping a url for the POST Request @RequestBody Customer customer:
     Return a customer object of created
     @PostMapping ensures that any request to the empty Url goes to createCustomer()
     */
    @PostMapping("")
    public Customer createCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    @GetMapping("/State/{state}")
    public List<Customer> getCustomerByState(@PathVariable("state")final String state){
        return customerService.getCustomerByState(state);
    }

    @GetMapping("/")
    public  List<Customer> getAllCustomers(){
        return  customerService.getAllCustomers();
    }

    @GetMapping("/id/{customerId}")
    public Optional<Customer> getCustomerById(@PathVariable("customerId")final Long customerId){
        return customerService.getCustomerById(customerId);
    }

    @PutMapping("/Phone/{customerId}")
    public Customer updateCustomerPhoneNumber(@RequestBody Customer customer,@PathVariable Long customerId){
            return customerService.updateCustomerPhoneNumber(customer);
    }
}
