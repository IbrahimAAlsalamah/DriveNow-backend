package com.example.controller;

import com.example.entity.Customer;
import com.example.request.CreateStudentRequest;
import com.example.service.CustomerService;
import com.google.firebase.auth.FirebaseAuthException;
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
    public ResponseEntity<Customer> saveCustomer(
            @RequestHeader("Authorization") String authorization,
            @RequestBody CreateStudentRequest csr) throws FirebaseAuthException {
        return new ResponseEntity<>(customerService.createCustomer(csr, authorization), HttpStatus.OK);
    }

    @GetMapping("getCustomer")
    public ResponseEntity<Customer> getCustomer(
            @RequestHeader("Authorization") String token) throws FirebaseAuthException {
        return ResponseEntity.ok(customerService.getCustomer(token));
    }

    @PutMapping("updateCustomer")
    public ResponseEntity<Customer> UpdateCustomer(
            @RequestHeader("Authorization") String token,
            @RequestBody CreateStudentRequest csr) throws FirebaseAuthException {
        return ResponseEntity.ok(customerService.updateCustomer(csr, token));
    }
}
