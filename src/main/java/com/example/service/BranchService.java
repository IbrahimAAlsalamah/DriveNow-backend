package com.example.service;

import com.example.entity.*;
import com.example.repository.BranchRepository;
import com.example.repository.CarRepository;
import com.example.request.AddBranchRequest;
import com.example.request.AddCarRequest;
import com.example.request.SearchRequest;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BranchService {
    private final FirebaseAuth firebaseAuth;

    final BranchRepository branchRepository;
    final BookingService bookingService;
    final CarRepository carRepository;

    public Branch getBranch(String token) throws FirebaseAuthException {
       Branch branch = branchRepository.findByEmail(getEmailFromToken(token));
       System.out.println(branch);
        return branch;
    }

    public boolean isBranch(String email) {
        return null!=branchRepository.findByEmail(email);
    }

    public List<Car> getAvailableCarsByCity(SearchRequest searchRequest) {
        List<Branch> branches = branchRepository.findByCity(searchRequest.getCity());
        List<Car> allAvailableCars = new ArrayList<>();

        for (Branch branch : branches) {
            List<Car> availableCars = branch.getCars().stream()
                    .filter(car -> bookingService.checkAvailbilty(
                            car.getId(), searchRequest.getStart(), searchRequest.getEnd()) && car.isAvailable())
                    .collect(Collectors.toList());

            allAvailableCars.addAll(availableCars);
        }
        return allAvailableCars;
    }

    public List<Car> getCarsByBranch(Long branchId) {
        Branch branch = branchRepository.findById(branchId).get();
        return branch.getCars();
    }

    private String getEmailFromToken(String token) throws FirebaseAuthException {
        String idToken = token.replace("Bearer ", "");
        FirebaseToken decodedToken = firebaseAuth.verifyIdToken(idToken);
        return decodedToken.getEmail();
    }

    public double Incomes(String token) throws FirebaseAuthException {
        Branch branch = branchRepository.findByEmail(getEmailFromToken(token));
        double incomes = 0;
        for (Receipt receipt : branch.getReceipts()) {
            incomes += receipt.getAmount();
            System.out.println(incomes);
        }
        return incomes;
    }

    public double Rates(String token) throws FirebaseAuthException {
        Branch branch = branchRepository.findByEmail(getEmailFromToken(token));
        double rates = 0;
        if(branch.getReviews().isEmpty()) {return 0.0;}
        for(Review review : branch.getReviews()) {
            rates += review.getRating();
            System.out.println(rates);
            System.out.println(branch.getReviews());
        }
        return rates / branch.getReviews().size();
    }

//    public List<Booking> GetCurrentBookings(String token) throws FirebaseAuthException {
//        Branch branch = branchRepository.findByEmail(getEmailFromToken(token));
//        List<Booking> bookings = branch.getBookings();
//        return bookings.stream().filter(booking -> "Confirmed".equals(booking.getStatus()))
//                .collect(Collectors.toList());
//    }

    public List<Car> getCars(String token) throws FirebaseAuthException {
        Branch branch = branchRepository.findByEmail(getEmailFromToken(token));
        return branch.getCars();
    }

//    public List<Booking> GetPastBookings(String token) throws FirebaseAuthException {
//        Branch branch = branchRepository.findByEmail(getEmailFromToken(token));
//        List<Booking> bookings = branch.getBookings();
//        return bookings.stream().filter(booking -> !"Confirmed".equals(booking.getStatus()))
//                .collect(Collectors.toList());
//    }

    public Car addCar(AddCarRequest car, String token) throws FirebaseAuthException {
        Car newCar = new Car(car);
        Branch branch = branchRepository.findByEmail(getEmailFromToken(token));
        newCar.setBranch(branch);
        branch.getCars().add(newCar);
        return carRepository.save(newCar);
    }

    public List<Branch> getBranchesByCity(String city) {
        return branchRepository.findByCity(city);
    }

    public List<Booking> getBookings(String token) throws FirebaseAuthException {
        Branch branch = branchRepository.findByEmail(getEmailFromToken(token));
        List<Booking> bookings = new ArrayList<>();
        for (Car car : branch.getCars()) {
            bookings.addAll(car.getBookings());
        }
        return bookings;
    }

    public List<Receipt> getReceipts(String token) throws FirebaseAuthException {
        Branch branch = branchRepository.findByEmail(getEmailFromToken(token));
        return branch.getReceipts();
    }

    public List<Review> getReviews(String token) throws FirebaseAuthException {
        Branch branch = branchRepository.findByEmail(getEmailFromToken(token));
        return branch.getReviews();
    }

    public List<Review> getReviewsByBranch(Long branchId) {
        Branch branch = branchRepository.findById(branchId).orElse(null);
        System.out.println(branch.getReviews());
        return branch.getReviews();
    }

    public double getBranchRating(Long id) {
        Branch branch = branchRepository.findById(id).orElse(null);
        double rates = 0;
        if(branch.getReviews().isEmpty()) {return 5.0;}
        for(Review review : branch.getReviews()) {
            rates += review.getRating();
        }
        return rates / branch.getReviews().size();
    }
}
