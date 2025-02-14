package com.example.controller;

import com.example.request.CheckAvailbiltyRequest;
import com.example.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @GetMapping("checkAvailbilty")
    public boolean checkAvailbilty(CheckAvailbiltyRequest request) {

        return bookingService.checkAvailbilty(request);

    }

}
