package com.example.service;

import com.example.entity.Booking;
import com.example.entity.Car;
import com.example.repository.BookingRepository;
import com.example.repository.CarRepository;
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

        Car car = carRepository.findById(booking.getCar()).orElseThrow(() ->
                new RuntimeException("Car not found with ID: " + booking.getCar()));

        Booking newBooking = new Booking(booking,car);

        return bookingRepository.save(newBooking);
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}
