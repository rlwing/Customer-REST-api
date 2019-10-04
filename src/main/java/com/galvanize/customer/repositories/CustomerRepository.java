package com.galvanize.customer.repositories;

import com.galvanize.customer.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //indicates that this interface is a repository
/*
By extending JpaRepository we get a bunch of generic CRUD methods
 */
/*
Mapping Java objects to database tables and vice versa is called Object-relational mapping (ORM).
JPA is one possible approach to ORM. Via JPA the developer can map, store, update and retrieve data
from relational databases to Java objects and vice versa
 */
/*
Generics allow user defined types as arguments to interfaces and methods
It takes domain class to manage and id type of domain class as type arguments
 */
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    //User-defined method for finding customer by state
    List<Customer> findCustomerByState(String state);
}