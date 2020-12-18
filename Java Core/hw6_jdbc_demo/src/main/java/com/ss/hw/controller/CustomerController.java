package com.ss.hw.controller;

import com.ss.hw.dao.CustomerDao;
import com.ss.hw.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class CustomerController {
    private final CustomerDao customerDao;

    @Autowired
    public CustomerController(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @GetMapping("/")
    public String sayHello() {
        return "hello from Spring boot";
    }

    @PostMapping("/api/customers")
    public int addCustomer(@RequestBody Customer customer) {
        return this.customerDao.save(customer);
    }

    @GetMapping("/api/customers")
    public List<Customer> findAllCustomers() {
        return this.customerDao.findAll();
    }
}
