package com.example.request;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class AddCarRequest {

    private Long id;

    private String name;

    private String type;

    private String year;

    private double price;

    private String fuelType;

    private boolean isAvailable;

    private int capacity;

    private String transmission;

}
