package com.galvanize.customer.services;

import com.galvanize.customer.entities.Customer;
import com.galvanize.customer.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //Mark class a service provider. Used with classes that provide some business functionalities
@Component  //Spring Component annotation is used to denote a class as Component. It means that Spring framework will
            // autodetect these classes for dependency injection when annotation-based configuration and classpath
            // scanning is used.
public class CustomerService {

    @Autowired
    CustomerRepository repository;

    //Add a customer to the database
    public Customer addCustomer(Customer customer) {
        return repository.save(customer);
    }

    //Retrieve details of all customers who have the same state
    public List<Customer> getCustomerByState(String state) {
        return repository.findCustomerByState(state);
    }

    //Retrieve details fpr all customers
    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    //Retrieve customers based on the their id
    public Optional<Customer> getCustomerById(Long customerId) {
        return repository.findById(customerId);
    }

    //Update a customers phone number
    public Customer updateCustomerPhoneNumber(Customer customer1) {
        return repository.save(customer1);
    }
}
