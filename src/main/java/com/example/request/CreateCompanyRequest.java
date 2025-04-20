package com.example.request;
import lombok.Data;

import java.util.List;
@Data
public class CreateCompanyRequest {

    private String name;

    private String address;

    private String street;

    private String city;

    private Double latitude;

    private Double longitude;

    private Boolean inAirport;


}
