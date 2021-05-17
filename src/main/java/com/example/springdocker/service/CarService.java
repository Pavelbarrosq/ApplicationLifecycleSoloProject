package com.example.springdocker.service;

import com.example.springdocker.model.Car;
import com.example.springdocker.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CarService {
    private final CarRepository repository;

    public List<Car>getAllCars() { return repository.findAll(); }

    public Car saveNewCar(Car car) {
        repository.save(car);
        return car;
    }

    public List<String> getAutomaticCars() {
        List<Car> automaticCars = repository.getAllByAutomatic(true);

        return automaticCars.stream()
                .map(car -> car.getModel())
                .collect(Collectors.toList());
    }
}
