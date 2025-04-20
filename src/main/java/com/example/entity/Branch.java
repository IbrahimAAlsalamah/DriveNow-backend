package com.example.entity;

import com.example.request.AddBranchRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
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

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "inAirport")
    private Boolean inAirport;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public Branch(AddBranchRequest addBranchRequest) {
        this.street = addBranchRequest.getStreet();
        this.city = addBranchRequest.getCity();
        this.latitude = addBranchRequest.getLatitude();
        this.longitude = addBranchRequest.getLongitude();
        this.inAirport = addBranchRequest.getInAirport();
    }
}
