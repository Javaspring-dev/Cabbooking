package com.example.carbooking.service;

import com.example.carbooking.Exception.ConflictException;
import com.example.carbooking.Exception.GobalExceptionHandler;
import com.example.carbooking.entities.BookingEntity;
import com.example.carbooking.entities.CarEntity;
import com.example.carbooking.repository.BookingRepository;
import com.example.carbooking.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private CarRepository carRepository;

    public BookingEntity booked (BookingEntity bookingEntity){
            if (bookingEntity.getCarid() <= 0) {
                throw new ConflictException("Invalid car ID");
            }

            if (bookingEntity.getUserid() <= 0) {
                throw new ConflictException("Invalid user ID");
            }

            if (bookingEntity.getStarttime() == null || bookingEntity.getEndtime() == null) {
                throw new ConflictException("Start time and end time cannot be null");
            }
            if (bookingEntity.getStarttime().compareTo(bookingEntity.getEndtime()) >= 0) {
                throw new ConflictException("End time must be after start time");
            }

            return bookingRepository.save(bookingEntity);
        }
        public List<CarEntity> getActiveCar(){
            return carRepository.findByAvailabilityTrue();
        }

    }
