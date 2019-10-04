package com.galvanize.customer.services;

import com.galvanize.customer.entities.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CustomerServiceTests {

    @Autowired
    CustomerService service;

    List<Customer> customers = new ArrayList<>();
    Customer customer = new Customer();
    @Before
    public void setUp() throws Exception {

        //Set values for customer
        customer.setAddress("2 East Ave");
        customer.setCity("Upper Marlboro");
        customer.setFirstName("Jane");
        customer.setLastName("Jack");
        customer.setState("MD");
        customer.setZip("20772");
        customer.setPhoneNumber("6573094627");
        customer.setDateJoined(new Date(12/12/2019));
    }

    @Test
    public void addCustomer() throws Exception {
       Customer newCustomer =  service.addCustomer(customer);
       assertNotNull(newCustomer.getCustomerId());
    }

    @Test
    public void getCustomersByState() throws Exception {
        String state = "TN";
        List<Customer> newCustomer = service.getCustomerByState(state);
        assertNotNull(newCustomer);
    }

    @Test
    public void getAllCustomers() throws Exception {
        List<Customer> allCustomers = service.getAllCustomers();
        assertNotNull(allCustomers);
    }

    @Test
    public void getCustomerById() throws Exception {
        Long customerId = Long.valueOf(5);
        Optional<Customer> customerList = service.getCustomerById(customerId);
        assertNotNull(customerList);
    }

    @Test
    public void updateCustomerPhoneNumber() throws Exception {
        Optional<Customer> newCustomer =  service.getCustomerById(Long.valueOf(5));
        Customer customer1 = newCustomer.get();
        customer1.setPhoneNumber("9061123783");
        service.updateCustomerPhoneNumber (customer1);
        assertEquals("9061123783",customer1.getPhoneNumber());
    }
}
