package com.example.entity;

import com.example.request.CreateCompanyRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "company")
    private List<Car> cars;

    @OneToMany(mappedBy = "company")
    private List<Complaint> complains;

    @OneToMany(mappedBy = "company")
    private List<Review> reviews;

    @OneToMany(mappedBy = "company")
    private List<Branch> branches;

    public Company(CreateCompanyRequest createCompanyRequest) {
        this.name = createCompanyRequest.getName();
        this.address = createCompanyRequest.getAddress();
    }

}
