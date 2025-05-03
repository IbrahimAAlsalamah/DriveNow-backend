package com.example.controller;

import com.example.entity.Receipt;
import com.example.service.ReceiptService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/receipt")
public class ReceiptController {

    private final ReceiptService receiptService;

//    @GetMapping("getByBookingId/{id}")
//    public ResponseEntity<Receipt> getReceiptById(@PathVariable Long id) {
//        return new ResponseEntity<>(receiptService.getReceiptById(id), HttpStatus.OK);
//    }

}
