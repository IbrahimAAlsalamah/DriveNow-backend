package com.example.request;


import lombok.Data;
import java.util.Date;

@Data
public class CreateStudentRequest {

    private String firstName;

    private String lastName;

    private Date birthDate;

    private String email;

    private String phone;








}
