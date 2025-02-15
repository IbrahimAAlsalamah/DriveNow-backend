package com.example.entity;

import com.example.request.AddCarRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "year")
    private String year;

    @Column(name = "price")
    private double price;

    @Column(name = "fuel_type")
    private String fuelType;

    @OneToMany(mappedBy = "car")
    private List<Booking> bookings;

    public Car(AddCarRequest addCarRequest) {
        this.type = addCarRequest.getType();
        this.year = addCarRequest.getYear();
        this.price = addCarRequest.getPrice();
        this.fuelType = addCarRequest.getFuelType();
    }

}
