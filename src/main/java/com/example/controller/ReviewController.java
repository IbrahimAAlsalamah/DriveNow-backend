package com.example.controller;

import com.example.entity.Review;
import com.example.request.CreateReviewRequest;
import com.example.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/review/")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("create")
    public ResponseEntity<Review> createReview(@RequestBody CreateReviewRequest review) {
        return new ResponseEntity<>(reviewService.createReview(review), HttpStatus.OK);
    }

//    @GetMapping("getReviewsByCarId/{carId}")
//    public ResponseEntity<List<Review>> getReviewsByCarId(@PathVariable Long carId) {
//        return new ResponseEntity<>(reviewService.getReviewsByCarId(carId),HttpStatus.OK);
//    }
}
