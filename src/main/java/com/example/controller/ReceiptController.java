package com.example.controller;

import com.example.service.ReceiptService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/receipt")
public class ReceiptController {

    private final ReceiptService receiptService;
}
