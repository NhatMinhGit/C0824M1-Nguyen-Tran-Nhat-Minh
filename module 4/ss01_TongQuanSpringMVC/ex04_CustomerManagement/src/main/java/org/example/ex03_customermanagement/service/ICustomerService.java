package org.example.ex03_customermanagement.service;

import org.example.ex03_customermanagement.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
}
