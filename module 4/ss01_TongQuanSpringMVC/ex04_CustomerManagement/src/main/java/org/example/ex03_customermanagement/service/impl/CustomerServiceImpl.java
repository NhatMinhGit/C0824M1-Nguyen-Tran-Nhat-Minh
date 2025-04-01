package org.example.ex03_customermanagement.service.impl;

import org.example.ex03_customermanagement.model.Customer;
import org.example.ex03_customermanagement.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {

    private static final List<Customer> customers = new ArrayList<>();

    static {
        customers.add(new Customer(1L, "Nguyễn Văn A", "a@example.com","Trần Hưng Đạo"));
        customers.add(new Customer(2L, "Trần Thị B", "b@example.com","Trần Quốc Toản"));
        customers.add(new Customer(3L, "Lê Văn C", "c@example.com","Trần Quốc Tuấn"));
    }
    @Override
    public List<Customer> findAll() {
        return customers;
    }
}
