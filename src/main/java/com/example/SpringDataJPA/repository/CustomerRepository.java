package com.example.SpringDataJPA.repository;

import com.example.SpringDataJPA.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}