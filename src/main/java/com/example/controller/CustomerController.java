package com.example.controller;

import com.example.entity.Customer;
import com.example.request.CreateStudentRequest;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/customer/")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("create")
    public ResponseEntity<Customer> CreateCustomer(@RequestBody CreateStudentRequest csr){
        return new ResponseEntity<>(customerService.createCustomer(csr), HttpStatus.OK);
    }

}
