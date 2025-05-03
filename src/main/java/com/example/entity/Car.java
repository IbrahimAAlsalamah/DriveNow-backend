package com.example.entity;

import com.example.request.AddCarRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "year")
    private String year;

    @Column(name = "price")
    private double price;

    @Column(name = "is_available")
    private boolean isAvailable = false;

    @Column(name = "fuel_type")
    private String fuelType;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "transmission")
    private String transmission;


    @OneToMany(mappedBy = "car")
    @JsonIgnore
    private List<Booking> bookings;

    @ManyToOne
    @JoinColumn(name="branch_id")
    @JsonIgnore
    @ToString.Exclude
    private Branch branch;

    public Car(AddCarRequest addCarRequest) {
        this.name = addCarRequest.getName();
        this.type = addCarRequest.getType();
        this.year = addCarRequest.getYear();
        this.price = addCarRequest.getPrice();
        this.fuelType = addCarRequest.getFuelType();
        this.isAvailable = addCarRequest.isAvailable();
        this.capacity = addCarRequest.getCapacity();
        this.transmission = addCarRequest.getTransmission();
    }

    public void updateCar(AddCarRequest addCarRequest) {
        this.name = addCarRequest.getName();
        this.type = addCarRequest.getType();
        this.year = addCarRequest.getYear();
        this.price = addCarRequest.getPrice();
        this.fuelType = addCarRequest.getFuelType();
        this.isAvailable = addCarRequest.isAvailable();
        this.capacity = addCarRequest.getCapacity();
        this.transmission = addCarRequest.getTransmission();
    }

    public String getCompanyName() {
        return branch.getCompanyName();
    }

    public long getBranchId() {
        return branch.getId();
    }

}
