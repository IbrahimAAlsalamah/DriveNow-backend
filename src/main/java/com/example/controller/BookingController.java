package com.example.controller;

import com.example.entity.Booking;
import com.example.request.AddBookingRequest;
import com.example.request.CheckAvailbiltyRequest;
import com.example.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("add")
    public void addBooking(@RequestBody AddBookingRequest booking) {
        bookingService.addBooking(booking);
    }

//    @GetMapping("checkAvailbilty")
//    public boolean checkAvailbilty(@RequestBody CheckAvailbiltyRequest request) {
//        return bookingService.checkAvailbilty(request);
//    }

    @GetMapping("getById/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {
        return new ResponseEntity<>(bookingService.getBookingById(id), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public void deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
    }

    @PutMapping("updateStatus/{id}/{status}")
    public ResponseEntity<Booking> updateBookingStatus(@PathVariable Long id,@PathVariable String status) {
        return new ResponseEntity<>(bookingService.updateBookingStatus(id,status),HttpStatus.OK);
    }

    @PutMapping("setStatus/{id}/{status}")
    public void setBookingStatus(@PathVariable Long id, @PathVariable String status) {
        bookingService.setStatus(id, status);
    }

}
