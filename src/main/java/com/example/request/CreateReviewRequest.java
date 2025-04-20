package com.example.request;

import lombok.Data;

@Data
public class CreateReviewRequest {

    private double rating;

    private String comment;

    private Long customerId;

    private Long companyId;

}
