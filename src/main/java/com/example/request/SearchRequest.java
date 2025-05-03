package com.example.request;

import lombok.Data;

import java.util.Date;

@Data
public class SearchRequest {

    private String city;
    private Date start;
    private Date end;
}
