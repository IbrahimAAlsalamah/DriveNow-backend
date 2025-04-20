package com.example.request;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class AddCarRequest {

    private String name;

    private String type;

    private String year;

    private double price;

    private String fuelType;

}
