package com.example.controller;

import com.example.entity.Branch;
import com.example.entity.Company;
import com.example.request.AddBranchRequest;
import com.example.request.CreateCompanyRequest;
import com.example.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/company/")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping("create")
    public ResponseEntity<Company> CreateCompany(@RequestBody CreateCompanyRequest newCompany) {
        return new ResponseEntity<>(companyService.CreateCompany(newCompany), HttpStatus.OK);
    }

    @PostMapping("addBranch")
    public ResponseEntity<Branch> AddBranch(@RequestBody AddBranchRequest addBranchRequest) {
        return new ResponseEntity<>(companyService.AddBranchRequest(addBranchRequest), HttpStatus.OK);
    }
}
