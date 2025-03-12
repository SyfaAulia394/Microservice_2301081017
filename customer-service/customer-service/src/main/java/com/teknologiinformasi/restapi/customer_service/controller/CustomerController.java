package com.teknologiinformasi.restapi.customer_service.controller;



import com.teknologiinformasi.restapi.customer_service.model.Customer;
import com.teknologiinformasi.restapi.customer_service.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerService service;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return service.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Optional<Customer> getCustomerById(@PathVariable Long id) {
        return service.getCustomerById(id);
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return service.saveCustomer(customer);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer newCustomer) {
        return service.getCustomerById(id).map(customer -> {
            customer.setName(newCustomer.getName());
            customer.setEmail(newCustomer.getEmail());
            customer.setAddress(newCustomer.getAddress());
            return service.saveCustomer(customer);
        }).orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        service.deleteCustomer(id);
    }
}
