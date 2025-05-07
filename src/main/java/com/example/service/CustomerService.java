package com.example.service;

import com.example.entity.Customer;
import com.example.repository.CustomerRepository;
import com.example.request.CreateStudentRequest;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final FirebaseAuth firebaseAuth;

    private final CustomerRepository customerRepository;

    public Customer createCustomer(CreateStudentRequest customer, String authorization) throws FirebaseAuthException{
        customer.setEmail(getEmailFromToken(authorization));
        Customer newCustomer = new Customer(customer);
        return customerRepository.save(newCustomer);
    }

    private String getEmailFromToken(String token) throws FirebaseAuthException {
        String idToken = token.replace("Bearer ", "");
        FirebaseToken decodedToken = firebaseAuth.verifyIdToken(idToken);
        return decodedToken.getEmail();
    }


    public Customer getCustomer(String token) throws FirebaseAuthException {
        return customerRepository.findByEmail(getEmailFromToken(token));
    }

    public Customer updateCustomer(CreateStudentRequest csr, String token) throws FirebaseAuthException {
        Customer customer = customerRepository.findByEmail(getEmailFromToken(token));
        customer.setFirstName(csr.getFirstName());
        customer.setLastName(csr.getLastName());
        customer.setPhone(csr.getPhone());
        customer.setBirthDate(csr.getBirthDate());
        customer.setEmail(getEmailFromToken(token));
        return customerRepository.save(customer);
    }
}
