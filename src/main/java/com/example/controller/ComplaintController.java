package com.example.controller;

import com.example.service.ComplaintService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/compliant")
public class ComplaintController {

    private final ComplaintService complaintService;
}
