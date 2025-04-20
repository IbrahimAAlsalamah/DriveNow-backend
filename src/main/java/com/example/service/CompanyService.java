package com.example.service;

import com.example.entity.Branch;
import com.example.entity.Company;
import com.example.repository.BranchRepository;
import com.example.repository.CompanyRepository;
import com.example.request.AddBranchRequest;
import com.example.request.CreateCompanyRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final BranchRepository branchRepository;


    public Company CreateCompany(CreateCompanyRequest company) {
        Company newCompany = new Company(company);
        return companyRepository.save(newCompany);
    }

    public Branch AddBranchRequest(AddBranchRequest branch) {
        Branch addBranch = new Branch(branch);
        return branchRepository.save(addBranch);
    }
}
