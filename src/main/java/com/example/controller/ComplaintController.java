package com.example.controller;

import com.example.entity.Complaint;
import com.example.exception.RequestException;
import com.example.exception.ResourceNotFoundException;
import com.example.request.CreateComplaintRequest;
import com.example.service.ComplaintService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/complaint/")
public class ComplaintController {

    private final ComplaintService complaintService;

    @PostMapping("create")
    public void CreateComplaint(@RequestBody CreateComplaintRequest newComplaint) {
        new ResponseEntity<>(complaintService.CreateCompliant(newComplaint), HttpStatus.OK);
    }

}
