package com.example.springdocker.service;

import com.example.springdocker.model.Car;
import com.example.springdocker.repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) //JUnit 5
class CarServiceTest {

    CarService service;

    @Mock
    CarRepository mockRepo;

    @BeforeEach
    public void init() {
        service = new CarService(mockRepo);
    }

    @Test
    void getAllCars() {
        Car c1 = new Car();
        c1.setModel("Mustang");
        c1.setAutomatic(true);

        when(mockRepo.findAll())
                .thenReturn(Arrays.asList(c1));

        //------------------------------

        List<Car> actual = service.getAllCars();
        assertEquals(c1.getModel(), actual.get(0).getModel());
        assertEquals(1, actual.size());
        assertTrue(actual.get(0).isAutomatic());

        //------------------------------

        verify(mockRepo).findAll();
    }

    @Test
    void saveNewCar() {
        Car c2 = new Car();
        c2.setModel("Skyline");
        c2.setAutomatic(false);

        when(mockRepo.save(any()))
                .thenReturn(c2);

        Car answer = service.saveNewCar(c2);

        assertEquals(c2.getModel(), answer.getModel());
        assertEquals(c2.isAutomatic(), answer.isAutomatic());
    }

    @Test
    void getAutomaticCars() {
        Car c3 = new Car();
        c3.setModel("Golf GTI");
        c3.setAutomatic(true);

        when(mockRepo.getAllByAutomatic(c3.isAutomatic()))
                .thenReturn(Arrays.asList(c3));

        List<String> expected = service.getAutomaticCars();

        assertEquals(c3.getModel(), expected.get(0));



    }
}