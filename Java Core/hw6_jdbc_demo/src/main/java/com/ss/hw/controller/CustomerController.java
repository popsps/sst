package com.ss.hw.controller;

//import com.ss.hw.dao.CustomerDao;
//import com.ss.hw.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
//    private final CustomerDao customerDao;

//    @Autowired
//    public CustomerController(CustomerDao customerDao) {
//        this.customerDao = customerDao;
//    }

    //    @GetMapping("/api/customers")
//    public List<Customer> findAllCustomers(){
//        return this.customerDao.findAll();
//    }
    @GetMapping("/api/customers")
    public String findAllCustomers() {
        return "hi";
    }
}
