package com.trainingmug.junit.repository;

import com.trainingmug.junit.model.Customer;

import java.util.List;

public class CustomerRepository {

    List<Customer> customers;
    public CustomerRepository(List<Customer> customers) {
        this.customers = customers;
    }
    /*
    without exceptions
    write CRUD methods
    Optional<Customer> findById(int id);
    List<Customer> findAll();
    Customer save(Customer customer);
    Customer update(Customer customer);
    void deleteById(int id);
    List<String> getCustomerNames();
    Optional<Customer> findCustomerByHighestBalance();
    Optional<Customer> findCustomerByLowestBalance();
    List<Customer> sortCustomersByNameAsc();
    List<Customer> sortCustomersByNameDesc();
     */
}
