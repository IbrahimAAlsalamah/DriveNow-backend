package com.example.request;

import lombok.Data;

@Data
public class AddBranchRequest {

    private String street;

    private String city;

    private String email;

    private String phone;

    private Double latitude;

    private Double longitude;

    private Boolean inAirport;
}
