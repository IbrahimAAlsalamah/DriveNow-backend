package com.example.request;

import lombok.Data;

@Data
public class AddBranchRequest {

    private String street;

    private String city;

    private Double latitude;

    private Double longitude;

    private Boolean inAirport;
}
