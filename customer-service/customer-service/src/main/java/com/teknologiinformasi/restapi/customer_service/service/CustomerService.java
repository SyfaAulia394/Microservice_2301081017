package com.teknologiinformasi.restapi.customer_service.service;

import com.teknologiinformasi.restapi.customer_service.model.Customer;
import com.teknologiinformasi.restapi.customer_service.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomersRepository repository;

    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    public Optional<Customer> getCustomerById(Long id) {
        return repository.findById(id);
    }

    public Customer saveCustomer(Customer customer) {
        return repository.save(customer);
    }

    public void deleteCustomer(Long id) {
        repository.deleteById(id);
    }
}
