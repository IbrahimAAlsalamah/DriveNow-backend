package com.example.response;


import com.example.entity.Customer;
import lombok.Data;

import java.util.Date;
@Data
public class CreateCustomerResponse {

    public CreateCustomerResponse(Customer customer) {
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
        this.email = customer.getEmail();
        this.phone = customer.getPhone();
        this.birthDate = customer.getBirthDate();
    }

    private String firstName;

    private String lastName;

    private Date birthDate;

    private String email;

    private String phone;

}
