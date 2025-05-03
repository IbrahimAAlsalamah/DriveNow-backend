package com.example.entity;

import com.example.request.AddBranchRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "branch")
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "inAirport")
    private Boolean inAirport;


    @OneToMany(mappedBy = "branch")
    private List<Car> cars;

    @OneToMany(mappedBy = "branch")
    private List<Receipt> receipts;

    @OneToMany(mappedBy = "branch")
    private List<Review> reviews;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public Branch(AddBranchRequest addBranchRequest) {
        this.street = addBranchRequest.getStreet();
        this.city = addBranchRequest.getCity();
        this.email = addBranchRequest.getEmail();
        this.phone = addBranchRequest.getPhone();
        this.latitude = addBranchRequest.getLatitude();
        this.longitude = addBranchRequest.getLongitude();
        this.inAirport = addBranchRequest.getInAirport();
    }

    public void UpdateBranch(AddBranchRequest addBranchRequest) {
        this.street = addBranchRequest.getStreet();
        this.city = addBranchRequest.getCity();
        this.email = addBranchRequest.getEmail();
        this.phone = addBranchRequest.getPhone();
        this.latitude = addBranchRequest.getLatitude();
        this.longitude = addBranchRequest.getLongitude();
        this.inAirport = addBranchRequest.getInAirport();
    }

    public String getCompanyName() {
        return company.getName();
    }

    public List<Booking> getBookings() {
        List<Booking> bookings = new ArrayList<>();
        for (Car car : cars) {
            bookings.addAll(car.getBookings());
        }
        return bookings;
    }

}
