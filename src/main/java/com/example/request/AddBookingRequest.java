package com.example.request;

import com.example.entity.Car;
import com.example.entity.Receipt;
import lombok.Data;

import java.util.Date;

@Data
public class AddBookingRequest {

    private Date startDate;

    private Date endDate;

    private Long carId;

    private Long customerId;

    private double amount;

    private String method;

}
