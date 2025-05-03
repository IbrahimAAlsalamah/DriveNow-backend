package com.example.response;

import com.example.entity.Branch;
import lombok.Data;

@Data
public class BranchDto {

    private Long id;
    private String street;
    private String city;
    private String email;
    private String phone;
    private Double latitude;
    private Double longitude;
    private Boolean inAirport;

    public BranchDto(Branch branch) {
        this.id = branch.getId();
        this.street = branch.getStreet();
        this.city = branch.getCity();
        this.email = branch.getEmail();
        this.phone = branch.getPhone();
        this.latitude = branch.getLatitude();
        this.longitude = branch.getLongitude();
        this.inAirport = branch.getInAirport();
    }
}
