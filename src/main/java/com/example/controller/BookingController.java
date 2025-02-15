package com.example.controller;

import com.example.entity.Booking;
import com.example.request.AddBookingRequest;
import com.example.request.CheckAvailbiltyRequest;
import com.example.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("add")
    public ResponseEntity<Booking> addBooking(@RequestBody AddBookingRequest booking) {
        return new ResponseEntity<>(bookingService.addBooking(booking),HttpStatus.OK);
    }

    @GetMapping("checkAvailbilty")
    public boolean checkAvailbilty(@RequestBody CheckAvailbiltyRequest request) {
        return bookingService.checkAvailbilty(request);
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {
        return new ResponseEntity<>(bookingService.getBookingById(id), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public void deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
    }

}
