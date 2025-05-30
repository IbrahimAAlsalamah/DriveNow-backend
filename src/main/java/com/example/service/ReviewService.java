package com.example.service;

import com.example.entity.Branch;
import com.example.entity.Company;
import com.example.entity.Customer;
import com.example.entity.Review;
import com.example.repository.BranchRepository;
import com.example.repository.CompanyRepository;
import com.example.repository.CustomerRepository;
import com.example.repository.ReviewRepository;
import com.example.request.CreateReviewRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final CustomerRepository customerRepository;
    private final BranchRepository branchRepository;


    public Review createReview(CreateReviewRequest review) {

        Customer customer = customerRepository.findById(review.getCustomerId()).orElseThrow( () ->
                new RuntimeException("Customer not found"));
        Branch branch = branchRepository.findById(review.getBranchId()).orElse(null);
        Review newReview = new Review(review);

        newReview.setCustomer(customer);
        newReview.setBranch(branch);

        return reviewRepository.save(newReview);
    }

//    public List<Review> getReviewsByCarId(Long id) {
//        return reviewRepository.findByCompany_id(id);
//    }
}
