package com.example.service;

import com.example.entity.*;
import com.example.repository.*;
import com.example.request.AddBookingRequest;
import com.example.request.CheckAvailbiltyRequest;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
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
        Receipt receipt = booking.getReceipt();
        receipt.setBranch(branchRepository.findById(booking.getBranchId()).orElse(null));
        newBooking.setReceipt(receipt);
        newBooking.setCustomer(booking.getCustomer());
        newBooking.setCar(booking.getCar());

        bookingRepository.save(newBooking);

        Branch branch = branchRepository.findById(booking.getBranchId()).orElse(null);
        if (branch != null && branch.getFcmToken() != null) {
            sendNotification(branch.getFcmToken(), "New Booking", "A new booking has been made!");
        }
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


    private void sendNotification(String token, String title, String body) {
        try {
            Message message = Message.builder()
                    .setToken(token)
                    .setNotification(Notification.builder()
                            .setTitle(title)
                            .setBody(body)
                            .build())
                    .build();

            String response = FirebaseMessaging.getInstance().send(message);
            System.out.println("Successfully sent message: " + response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
