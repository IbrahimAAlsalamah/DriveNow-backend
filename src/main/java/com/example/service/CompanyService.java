package com.example.service;

import com.example.entity.Branch;
import com.example.entity.Company;
import com.example.repository.BranchRepository;
import com.example.repository.CompanyRepository;
import com.example.request.AddBranchRequest;
import com.example.request.CreateCompanyRequest;
import com.example.request.UpdateInfoRequest;
import com.example.response.BranchDto;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final FirebaseAuth firebaseAuth;

    private final CompanyRepository companyRepository;
    private final BranchRepository branchRepository;

    public Boolean isCompany(String email) {
        return null!=companyRepository.findByEmail(email);
    }

    public Company CreateCompany(CreateCompanyRequest company) {
        Company newCompany = new Company(company);
        return companyRepository.save(newCompany);
    }

    public List<BranchDto> getBranches(String token) throws FirebaseAuthException {
      List<Branch> branches = companyRepository.findByEmail(getEmailFromToken(token)).getBranches();
      List<BranchDto> branchDtoList = new ArrayList<>();
      for (Branch branch : branches) {
          branchDtoList.add(new BranchDto(branch));
      }
      return branchDtoList;
    }

    public Branch AddBranchRequest(AddBranchRequest branch, String token) throws FirebaseAuthException {
        Branch addBranch = new Branch(branch);
        Company company = companyRepository.findByEmail(getEmailFromToken(token));
        addBranch.setCompany(company);
        company.getBranches().add(addBranch);
        companyRepository.save(company);
        return branchRepository.save(addBranch);
    }

    private String getEmailFromToken(String token) throws FirebaseAuthException {
        String idToken = token.replace("Bearer ", "");
        FirebaseToken decodedToken = firebaseAuth.verifyIdToken(idToken);
        return decodedToken.getEmail();
    }

    public Company UpdateInfo(UpdateInfoRequest uir, String token) throws FirebaseAuthException {
        Company company = companyRepository.findByEmail(getEmailFromToken(token));
        company.setName(uir.getName());
        company.setPhone(uir.getPhone());
        return companyRepository.save(company);
    }

    public Company getCompany(String token) throws FirebaseAuthException {
        return companyRepository.findByEmail(getEmailFromToken(token));
    }

    public Branch editBranch(AddBranchRequest abr, String token) {
        Branch branch = branchRepository.findByEmail(abr.getEmail());
        branch.UpdateBranch(abr);
        return branchRepository.save(branch);
    }
}
