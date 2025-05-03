package com.example.entity;

import com.example.request.AddBookingRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Optional;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "status")
    private String status = "Confirmed";

    @ManyToOne
    @JoinColumn(name="car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name="customer_id")
    @JsonIgnore
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "receipt_id")
    private Receipt receipt;

    public Booking(AddBookingRequest addBookingRequest) {
        this.startDate = addBookingRequest.getStartDate();
        this.endDate = addBookingRequest.getEndDate();
    }

    public String getCustomerName() {
        return customer.getFirstName() + " " + customer.getLastName();
    }

//    public String getCarType() {
//        return car.getType();
//    }

}
