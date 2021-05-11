package com.example.springdocker.controller;

import com.example.springdocker.model.Car;
import com.example.springdocker.repository.CarRepository;
import com.example.springdocker.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CarController {
    private final CarService carService;

    @GetMapping("/cars")
    public List<Car> getCars() { return carService.getAllCars(); }

    @PostMapping("/cars")
    public void saveNewCar(@RequestBody Car car) { carService.saveNewCar(car); }

    @GetMapping("/cars/automatic")
    public List<String> getAutomaticCars() { return carService.getAutomaticCars(); }
}
