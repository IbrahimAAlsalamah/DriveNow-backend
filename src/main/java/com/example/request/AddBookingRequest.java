package com.example.request;

import com.example.entity.Car;
import lombok.Data;

import java.util.Date;

@Data
public class AddBookingRequest {

    private Date startDate;

    private Date endDate;

    private Long car;

}
