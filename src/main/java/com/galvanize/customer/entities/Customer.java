package com.galvanize.customer.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
/*
Resource representation class
Create a new domain object to represent a Customer
Entities are POJOs representing data that can be persisted into the database
An entity represents a table in a database
Every instance of an entity represents a row in a database
 */
@Entity
/*
The entity name defaults to the name of the class. We can change its name using the name element.
Because various JPA implementations will try subclassing our entity in order to provide their functionality,
entity classes must not be declared final.
 */
public class Customer {
    /*
    Each JPA entity must have a primary key which uniquely identifies it
     */
    @Id     //Defines a primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Generate identifiers in different ways
                                                        //Generates an automatic value during commit
                                                        //for every new entity object(Identity)
    private long customerId;

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;

    /*
    @Column annotation to mention the details of a column in the table.
    If we don't specify this annotation, the name of the field will be considered the name of the column in the table.
     */
    @Column(columnDefinition = "date", name = "join_date")
    //name: specifies the name of the column in the table
    //columnDefinition: The SQL fragment that is used when generating the DDL for the column.
    /*
    Jackson annotation that is used to specify how to format fields and/or properties for JSON output.
    Allows you to specify how to format Date and Calendar values according to a SimpleDateFormat format.
     */
    @JsonFormat(pattern = "DD/MM/yyyy")
    private Date dateJoined;

    //Write getters and setters for accessing the private variables within the entire package
    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(Date dateJoined) {
        this.dateJoined = dateJoined;
    }
}
