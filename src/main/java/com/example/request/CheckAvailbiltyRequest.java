package com.example.request;

import lombok.Data;

import java.util.Date;

@Data
public class CheckAvailbiltyRequest {

    private Date startDate;

    private Date endDate;

}
