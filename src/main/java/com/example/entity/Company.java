package com.example.entity;

import com.example.request.CreateCompanyRequest;
import com.example.request.UpdateInfoRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "company")
    @JsonIgnore
    private List<Complaint> complains;

    @OneToMany(mappedBy = "company")
    @JsonIgnore
    private List<Branch> branches;

    public Company(CreateCompanyRequest createCompanyRequest) {
        this.name = createCompanyRequest.getName();
        //this.address = createCompanyRequest.getAddress();
    }

    public Company(UpdateInfoRequest updateInfoRequest) {
        this.name = updateInfoRequest.getName();
        this.phone = updateInfoRequest.getPhone();
    }

}
