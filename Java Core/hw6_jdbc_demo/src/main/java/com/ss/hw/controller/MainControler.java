package com.ss.hw.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainControler {
    @GetMapping("/")
    public String sayHello() {
        return "hello from Spring boot";
    }
}
