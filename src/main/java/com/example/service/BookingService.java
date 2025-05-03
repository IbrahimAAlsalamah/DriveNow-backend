package com.example.service;

import com.example.entity.*;
import com.example.repository.*;
import com.example.request.AddBookingRequest;
import com.example.request.CheckAvailbiltyRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final CarRepository carRepository;
    private final ReceiptRepository receiptRepository;
    private final CustomerRepository customerRepository;
    private final BranchRepository branchRepository;

    public boolean checkAvailbilty(long carId, Date startDate, Date endDate) {

        if(!carRepository.findById(carId).isPresent())
            return false;

        if (bookingRepository.checkAvailbilty(carId, startDate,endDate)==0){
            return true;
        }
        return false;
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    public void addBooking(AddBookingRequest booking) {

        Booking newBooking = new Booking(booking);
        receiptRepository.save(booking.getReceipt());

        newBooking.setReceipt(booking.getReceipt());
        newBooking.setCustomer(booking.getCustomer());
        newBooking.setCar(booking.getCar());

        bookingRepository.save(newBooking);
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    public Booking updateBookingStatus(Long id, String status) {
        Booking booking = bookingRepository.findById(id).orElse(null);
        booking.setStatus(status);
        return bookingRepository.save(booking);
    }

    public void setStatus(Long id, String status) {
        Booking booking = bookingRepository.findById(id).orElse(null);
        booking.setStatus(status);
        bookingRepository.save(booking);
    }
}
