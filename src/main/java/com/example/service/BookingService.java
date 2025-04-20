package com.example.service;

import com.example.entity.Booking;
import com.example.entity.Car;
import com.example.entity.Customer;
import com.example.entity.Receipt;
import com.example.repository.BookingRepository;
import com.example.repository.CarRepository;
import com.example.repository.CustomerRepository;
import com.example.repository.ReceiptRepository;
import com.example.request.AddBookingRequest;
import com.example.request.CheckAvailbiltyRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final CarRepository carRepository;
    private final ReceiptRepository receiptRepository;
    private final CustomerRepository customerRepository;

    public boolean checkAvailbilty(CheckAvailbiltyRequest request) {

        if(!carRepository.findById(request.getCarId()).isPresent())
            return false;

        if (bookingRepository.checkAvailbilty(request.getCarId(), request.getStartDate(),request.getEndDate())==0){
            return true;
        }
        return false;
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    public Booking addBooking(AddBookingRequest booking) {

        Car car = carRepository.findById(booking.getCarId()).orElseThrow(() ->
                new RuntimeException("Car not found with ID: " + booking.getCarId()));
        Customer customer = customerRepository.findById(booking.getCustomerId()).orElseThrow(() ->
                new RuntimeException("Customer not found"));

        Receipt receipt = new Receipt(booking.getAmount(), booking.getMethod());
        Booking newBooking = new Booking(booking);

        receiptRepository.save(receipt);

        newBooking.setReceipt(receipt);
        newBooking.setCustomer(customer);
        newBooking.setCar(car);

        return bookingRepository.save(newBooking);
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}
