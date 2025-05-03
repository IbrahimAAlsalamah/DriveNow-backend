package com.example.entity;

import com.example.request.CreateReviewRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "rating")
    private double rating;

    @Column(name = "comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name="branch_id")
    @JsonIgnore
    private Branch branch;

    @ManyToOne
    @JoinColumn(name="customer_id")
    @JsonIgnore
    private Customer customer;

    public Review(CreateReviewRequest createReviewRequest) {
        this.rating = createReviewRequest.getRating();
        this.comment = createReviewRequest.getComment();
    }

    public String getCustomerName() {
        return customer.getFirstName() + " " + customer.getLastName();
    }

}
