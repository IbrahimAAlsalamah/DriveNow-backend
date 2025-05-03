package com.example.service;

import com.example.entity.Car;
import com.example.repository.CarRepository;
import com.example.request.AddCarRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;


    public Car getCarById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    public List<Car> getCarsByYear(String year) {
        return carRepository.findByYear(year);
    }

    public List<Car> getCarsByType(String type) {
        return carRepository.findByType(type);
    }

    public Car updateAvailability(Long id, Boolean availability) {
        Car car = carRepository.findById(id).orElse(null);
        car.setAvailable(availability);
        return carRepository.save(car);
    }

    public Car updateCar(AddCarRequest car) {
        Car savedCar = carRepository.findById(car.getId()).orElse(null);
        savedCar.updateCar(car);
        return carRepository.save(savedCar);
    }
}
