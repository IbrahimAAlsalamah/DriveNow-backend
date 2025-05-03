package com.example.controller;

import com.example.entity.Car;
import com.example.request.AddCarRequest;
import com.example.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarController {

    @Autowired
    CarService carService;



    @GetMapping("getCar/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        return new ResponseEntity<>(carService.getCarById(id),HttpStatus.OK);
    }

    @GetMapping("getCarsByYear/{year}")
    public ResponseEntity<List<Car>> getCarsByYear(@PathVariable String year) {
        return new ResponseEntity<>(carService.getCarsByYear(year),HttpStatus.OK);
    }

    @GetMapping("getCarsByType/{type}")
    public ResponseEntity<List<Car>> getCarsByType(@PathVariable String type) {
        return new ResponseEntity<>(carService.getCarsByType(type),HttpStatus.OK);
    }

    @PutMapping("updateAvailability/{id}/{isAvailable}")
    public ResponseEntity<Car> updateAvailability(@PathVariable Long id, @PathVariable Boolean isAvailable) {
        return new ResponseEntity<>(carService.updateAvailability(id,isAvailable),HttpStatus.OK);
    }

    @PutMapping("updateCar")
    public ResponseEntity<Car> updateCar(@RequestBody AddCarRequest car) {
        return ResponseEntity.ok(carService.updateCar(car));
    }

}
