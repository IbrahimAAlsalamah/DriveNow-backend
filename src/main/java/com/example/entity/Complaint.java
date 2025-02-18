package com.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "complaint")
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name= "reason")
    private String reason;

    @Column(name= "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name="company_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

}
