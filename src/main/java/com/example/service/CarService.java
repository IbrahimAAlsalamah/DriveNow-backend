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

    public Car addCar(AddCarRequest car) {
        Car newCar = new Car(car);
        return carRepository.save(newCar);
    }

    public Car getCarById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    public List<Car> getCarsByYear(String year) {
        return carRepository.findByYear(year);
    }

    public List<Car> getCarsByType(String type) {
        return carRepository.findByType(type);
    }
}
