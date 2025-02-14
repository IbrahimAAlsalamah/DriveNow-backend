package com.example.service;

import com.example.repository.BookingRepository;
import com.example.request.CheckAvailbiltyRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;

    public boolean checkAvailbilty(CheckAvailbiltyRequest request) {
        if (bookingRepository.checkAvailbilty(request.getStartDate(),request.getEndDate())==0)
            return true;
        return false;
    }
}
