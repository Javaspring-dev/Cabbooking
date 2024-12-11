package com.example.carbooking.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class CarEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private int id;
    private int registrationnumber;
    private boolean availability;
    private String brand;
    private String model;
}
