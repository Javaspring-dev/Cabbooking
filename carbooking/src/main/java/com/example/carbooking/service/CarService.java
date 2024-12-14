package com.example.carbooking.service;

import com.example.carbooking.entities.CarEntity;
import com.example.carbooking.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarService {
     public final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public CarEntity create(CarEntity carEntity) {

        return carRepository.save(carEntity);
    }

    public Object getById(int id){
        Optional<CarEntity> FindById = carRepository.findById(id);
        if (FindById.isPresent()){
            return carRepository.findById(id);
        }
        return null;
    }
}