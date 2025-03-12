package com.teknologiinformasi.restapi.customer_service.repository;
import com.teknologiinformasi.restapi.customer_service.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepository extends JpaRepository<Customer, Long> {
}