package com.example.controller;

import com.example.entity.Branch;
import com.example.entity.Company;
import com.example.request.AddBranchRequest;
import com.example.request.CreateCompanyRequest;
import com.example.request.UpdateInfoRequest;
import com.example.response.BranchDto;
import com.example.service.CompanyService;
import com.google.firebase.auth.FirebaseAuthException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company/")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping("isCompany/{email}")
    public ResponseEntity<Boolean> isCompany(@PathVariable String email) {
        return new ResponseEntity<>(companyService.isCompany(email), HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<Company> CreateCompany(@RequestBody CreateCompanyRequest newCompany) {
        return new ResponseEntity<>(companyService.CreateCompany(newCompany), HttpStatus.OK);
    }

    @GetMapping("getBranches")
    public List<BranchDto> GetBranches(@RequestHeader("Authorization") String token) throws FirebaseAuthException {
        return companyService.getBranches(token);
    }

    @PostMapping("addBranch")
    public ResponseEntity<Branch> AddBranch(@RequestBody AddBranchRequest addBranchRequest,
                                            @RequestHeader("Authorization") String token) throws FirebaseAuthException {
        return new ResponseEntity<>(companyService.AddBranchRequest(addBranchRequest, token), HttpStatus.OK);
    }

    @PutMapping("updateInfo")
    public ResponseEntity<Company> UpdateInfo(@RequestBody UpdateInfoRequest UIR,
                                              @RequestHeader("Authorization") String token) throws FirebaseAuthException {
        return ResponseEntity.ok(companyService.UpdateInfo(UIR, token));
    }

    @GetMapping("getCompany")
    public ResponseEntity<Company> GetCompany(@RequestHeader("Authorization") String token) throws FirebaseAuthException {
        return ResponseEntity.ok(companyService.getCompany(token));
    }

    @PutMapping("editBranch")
    public ResponseEntity<Branch> EditBranch(@RequestBody AddBranchRequest abr,
                                             @RequestHeader("Authorization") String token) throws FirebaseAuthException {
        return ResponseEntity.ok(companyService.editBranch(abr,token));
    }
}
