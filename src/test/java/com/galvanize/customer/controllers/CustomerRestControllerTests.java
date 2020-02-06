package com.galvanize.customer.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.customer.entities.Customer;
import com.galvanize.customer.repositories.CustomerRepository;
import com.galvanize.customer.services.CustomerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
/*
The @SpringBootTest annotation tells Spring Boot to look for a main configuration class
(one with @SpringBootApplication, for instance) and use that to start a Spring application context.
*/
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class CustomerRestControllerTests {

    @Autowired
    MockMvc mvc;

    @Autowired
    CustomerService service;

    @Autowired
    CustomerRepository repository;
    String jsonPath ;
    @Before
    public void setUp() {

        //Set up
        jsonPath = "{\"address\":\"55 Hawthorne Rd\",\"city\":\"Raleigh\",\"dateJoined\":\"12/12/2019\",\"firstName\":\"Eva\",\"lastName" +
                "\":\"Mendez\"," +
                "\"phoneNumber\":\"9673019375\",\"state\":\"NC\",\"zip\":\"27603\"}";
    }

    @Test
    public void addCustomer() throws Exception {
        //Execute and Assertion
        mvc.perform(post("").contentType(MediaType.APPLICATION_JSON)
        .content(jsonPath))
                .andExpect(status().isOk())
                .andExpect(jsonPath("customerId").exists());
    }

    @Test
    public void getCustomersByState() throws Exception {
        mvc.perform(get("/State/NC"))
                .andExpect(status().isOk());
    }

    @Test
    public void getAllCustomers() throws Exception {
        mvc.perform(get("/"))
                .andExpect(status().isOk());
    }

   @Test
    public void getCustomerById() throws Exception {
        mvc.perform(get("/id/5"))
                .andExpect(status().isOk());
    }

    @Test
    public void updateCustomerPhoneNumber() throws Exception {
        Optional<Customer> customerList = service.getCustomerById(3L);
        Customer customer = customerList.get();
        customer.setPhoneNumber("4545454545");
        mvc.perform(put("/Phone/{customerId}", customer.getCustomerId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(customer)))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("customerId").value(customer.getCustomerId()));
    }
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
