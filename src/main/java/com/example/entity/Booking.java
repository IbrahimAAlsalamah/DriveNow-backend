package com.example.entity;

import com.example.request.AddBookingRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Optional;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Long id;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @ManyToOne
    @JoinColumn(name="car_id")
    private Car car;

    public Booking(AddBookingRequest addBookingRequest, Car car) {
        this.startDate = addBookingRequest.getStartDate();
        this.endDate = addBookingRequest.getEndDate();
        this.car = car;
    }

}
