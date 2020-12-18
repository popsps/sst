package com.ss.hw.controller;

import com.ss.hw.dao.CustomerDao;
import com.ss.hw.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class MainControler {
    private final CustomerDao customerDao;

    @Autowired
    public MainControler(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }
    @GetMapping("/")
    public String sayHello() {
        return "hello from Spring boot";
    }
    @GetMapping("/api/customer")
    public String findAllCustomer() {
        return "hi";
    }

    @GetMapping("/api/customers")
    public List<Customer> findAllCustomers() {
        return this.customerDao.findAll();
    }
}
