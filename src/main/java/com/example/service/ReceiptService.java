package com.example.service;

import com.example.entity.Receipt;
import com.example.repository.BookingRepository;
import com.example.repository.ReceiptRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReceiptService {

    //private final ReceiptRepository receiptRepository;
    private final BookingRepository bookingRepository;

    public Receipt getReceiptById(Long id) {
        return bookingRepository.findById(id).orElseThrow( () ->
                new RuntimeException("receipt not found")).getReceipt();
    }
}
