package com.example.entity;

import com.example.request.CreateStudentRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birthdate")
    private Date birthDate;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @OneToMany(mappedBy = "customer")
    private List<Booking> bookings;

    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private List<Complaint> complaints;

    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private List<Review> reviews;

    public Customer(CreateStudentRequest csr){
        this.firstName = csr.getFirstName();
        this.lastName = csr.getLastName();
        this.email = csr.getEmail();
        this.phone = csr.getPhone();
        this.birthDate = csr.getBirthDate();
    }

}
