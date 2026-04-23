package com.trainingmug.junit.service;

import com.trainingmug.junit.exception.CustomerExistsException;
import com.trainingmug.junit.exception.CustomerNotFoundException;
import com.trainingmug.junit.model.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static junit.framework.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CustomerServiceTest {

    private CustomerService customerService;
    private List<Customer> customers;

    @BeforeEach
    public void setUp() {
        customers = List.of(
                Customer.builder().id(1).name("John").email("john@gmail.com").balance(100.0).build(),
                Customer.builder().id(2).name("Jane").email("jane@gmail.com").balance(200.0).build()
        );
        customerService = new CustomerService(customers);
    }

    @Test
    @DisplayName("Should add customer successfully when valid data is provided")
    void shouldAddCustomerWhenValidData() {
        Customer customer = new Customer(3, "John", "john@test.com", 1500);

        Customer result = customerService.addCustomer(customer);

        assertEquals("John", result.getName());
        assertEquals(3, customerService.getAllCustomers().size());
    }

    @Test
    @DisplayName("Should throw exception when adding customer with duplicate ID")
    void shouldThrowExceptionWhenAddingDuplicateCustomer() {
        Customer duplicate = new Customer(1, "Test", "test@test.com", 500);

        assertThrows(CustomerExistsException.class,
                () -> customerService.addCustomer(duplicate));
    }

    @Test
    @DisplayName("Should return customer when valid ID is provided")
    void shouldReturnCustomerWhenValidId() {
        Customer customer = customerService.getCustomerById(1);

        assertEquals("Madhu", customer.getName());
    }

    @Test
    @DisplayName("Should throw exception when customer ID does not exist")
    void shouldThrowExceptionWhenCustomerNotFound() {

        assertThrows(CustomerNotFoundException.class,
                () -> customerService.getCustomerById(100));
    }

    @Test
    @DisplayName("Should delete customer when valid ID is provided")
    void shouldDeleteCustomerWhenValidId() {
        boolean result = customerService.deleteCustomer(1);
        assertTrue(result);
        assertEquals(1, customerService.getAllCustomers().size());
    }

    @Test
    @DisplayName("Should throw exception when deleting non-existing customer")
    void shouldThrowExceptionWhenDeletingNonExistingCustomer() {

        assertThrows(CustomerNotFoundException.class,
                () -> customerService.deleteCustomer(999));
    }

    @Test
    @DisplayName("Should return all customers")
    void shouldReturnAllCustomers() {
        assertEquals(2, customerService.getAllCustomers().size());
    }

    @Test
    @DisplayName("Should return total balance of all customers")
    void shouldReturnTotalBalance() {
        double total = customerService.getTotalBalance();

        assertEquals(3000, total);
    }

    @AfterEach
    public void tearDown() {
        customerService = null;
        customers = null;
    }


}
