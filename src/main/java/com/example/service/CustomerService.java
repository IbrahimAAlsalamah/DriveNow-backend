package com.example.service;

import com.example.entity.Car;
import com.example.entity.Customer;
import com.example.repository.CustomerRepository;
import com.example.request.AddCarRequest;
import com.example.request.CreateStudentRequest;
import com.example.response.CreateCustomerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.function.EntityResponse;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer createCustomer(CreateStudentRequest customer) {
        Customer newCustomer = new Customer(customer);
        return customerRepository.save(newCustomer);
    }



}
