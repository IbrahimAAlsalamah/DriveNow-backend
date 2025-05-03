package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "receipt")
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name= "amount")
    private double amount;

    @Column(name= "method")
    private String method;

//    @OneToOne
//    @JoinColumn(name = "booking_id")
//    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    @JsonIgnore
    private Branch branch;


    public Receipt(double amount, String method) {
        this.amount = amount;
        this.method = method;
    }
}
