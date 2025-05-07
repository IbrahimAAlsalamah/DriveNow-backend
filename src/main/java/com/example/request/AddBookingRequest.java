package com.example.request;

import com.example.entity.Car;
import com.example.entity.Customer;
import com.example.entity.Receipt;
import lombok.Data;

import java.util.Date;

@Data
public class AddBookingRequest {

    private Date startDate;

    private Date endDate;

    private Car car;

    private Customer customer;

    private Receipt receipt;

    private Long branchId;

}
