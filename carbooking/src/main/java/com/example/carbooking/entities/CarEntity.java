package com.example.carbooking.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Car")
public class CarEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private int id;
    private int registrationnumber;
    private boolean availability;
    private String brand;
    private String model;
}
