package com.example.service;

import com.example.entity.Company;
import com.example.entity.Complaint;
import com.example.entity.Customer;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.CompanyRepository;
import com.example.repository.ComplaintRepository;
import com.example.repository.CustomerRepository;
import com.example.request.CreateComplaintRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ComplaintService {

    private final ComplaintRepository complaintRepository;
    private final CustomerRepository customerRepository;
    private final CompanyRepository companyRepository;

    public Complaint CreateCompliant(CreateComplaintRequest newComplaint) {

        Company company = companyRepository.findById(
                newComplaint.getCompanyId()).orElseThrow( () ->
                new ResourceNotFoundException("Customer not found "));
        Customer customer = customerRepository.findById(
                newComplaint.getCustomerId()).orElseThrow( () ->
                        new ResourceNotFoundException("Customer not found "));

        Complaint complaint = new Complaint(newComplaint,customer,company);

        customer.getComplaints().add(complaint);
        company.getComplains().add(complaint);

        return complaintRepository.save(complaint);
    }
}
