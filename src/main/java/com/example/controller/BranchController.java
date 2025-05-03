package com.example.controller;

import com.example.entity.*;
import com.example.request.AddBranchRequest;
import com.example.request.AddCarRequest;
import com.example.request.SearchRequest;
import com.example.service.BranchService;
import com.google.firebase.auth.FirebaseAuthException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/branch/")
@RequiredArgsConstructor
public class BranchController {

    final BranchService branchService;

    @GetMapping("getBranch")
    public ResponseEntity<Branch> getBranch(
            @RequestHeader("Authorization") String token) throws FirebaseAuthException {
        return new ResponseEntity<>(branchService.getBranch(token), HttpStatus.OK);
    }

    @GetMapping("/isBranch/{email}")
    public boolean isBranch(@PathVariable String email) {
        return branchService.isBranch(email);
    }

    @PostMapping("getAvailableCarsByCity")
    public ResponseEntity<List<Car>> getAvailableCarsByCity(@RequestBody SearchRequest searchRequest) {
        return new ResponseEntity<>(branchService.getAvailableCarsByCity(searchRequest), HttpStatus.OK);
    }

    @GetMapping("getCarsByBranch")
    public ResponseEntity<List<Car>> getCarsByBranch(Long id) {
        return ResponseEntity.ok(branchService.getCarsByBranch(id));
    }

    @GetMapping("getIncomes")
    public double Incomes(@RequestHeader("Authorization") String token) throws FirebaseAuthException {
        return branchService.Incomes(token);
    }

    @GetMapping("getRates")
    public double Rates(@RequestHeader("Authorization") String token) throws FirebaseAuthException {
        return branchService.Rates(token);
    }

//    @GetMapping("getCurrentBookings")
//    public ResponseEntity<List<Booking>> getCurrentBookings(
//            @RequestHeader("Authorization") String token) throws FirebaseAuthException{
//        return ResponseEntity.ok(branchService.GetCurrentBookings(token));
//    }

//    @GetMapping("getPastBookings")
//    public ResponseEntity<List<Booking>> getPastBookings(
//            @RequestHeader("Authorization") String token) throws FirebaseAuthException{
//        return ResponseEntity.ok(branchService.GetPastBookings(token));
//    }

    @GetMapping("getCars")
    public ResponseEntity<List<Car>> getCars(
            @RequestHeader("Authorization") String token) throws FirebaseAuthException {
        return ResponseEntity.ok(branchService.getCars(token));
    }

    @PostMapping("addCar")
    public ResponseEntity<Car> addCar(@RequestBody AddCarRequest car,
                                      @RequestHeader("Authorization") String token)  throws FirebaseAuthException{
        return new ResponseEntity<>(branchService.addCar(car,token), HttpStatus.OK);
    }

    @GetMapping("getBranchesByCity/{city}")
    public ResponseEntity<List<Branch>> getBranchesByCity(@PathVariable String city) {
        return ResponseEntity.ok(branchService.getBranchesByCity(city));
    }

    @GetMapping("getBookings")
    public ResponseEntity<List<Booking>> getBookings(@RequestHeader("Authorization") String token) throws FirebaseAuthException {
        return ResponseEntity.ok(branchService.getBookings(token));
    }

    @GetMapping("getReviews")
    public ResponseEntity<List<Review>> getReviews(@RequestHeader("Authorization") String token) throws FirebaseAuthException {
        return ResponseEntity.ok(branchService.getReviews(token));
    }

    @GetMapping("getReceipts")
    public ResponseEntity<List<Receipt>> getReceipts(@RequestHeader("Authorization") String token) throws FirebaseAuthException {
        return ResponseEntity.ok(branchService.getReceipts(token));
    }

    @GetMapping("getReviewsByBranchId/{id}")
    public ResponseEntity<List<Review>> getReviewsByBranchId(@PathVariable Long id) {
        return ResponseEntity.ok(branchService.getReviewsByBranch(id));
    }

    @GetMapping("getRateByBranchId/{id}")
    public double getRateByBranchId(@PathVariable Long id) {
        return branchService.getBranchRating(id);
    }

}
