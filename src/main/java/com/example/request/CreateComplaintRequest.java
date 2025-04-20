package com.example.request;

import jakarta.persistence.Column;
import lombok.Data;

import java.util.Date;
@Data
public class CreateComplaintRequest {

    private String reason;

    private Date date;

    private Long companyId;

    private Long customerId;

}
