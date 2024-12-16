package com.example.carbooking.contoller;

import com.example.carbooking.entities.CarEntity;
import com.example.carbooking.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/cars")
public class CarController {
    @Autowired
    private CarService carService;
    @PostMapping("/create")
    public CarEntity createCar(@RequestBody CarEntity carEntity) {
        return carService.create(carEntity);
    }

    @GetMapping("/{id}")
    public CarEntity getCarById(@PathVariable Long id) {
        return (CarEntity) carService.getById(id);
}

}