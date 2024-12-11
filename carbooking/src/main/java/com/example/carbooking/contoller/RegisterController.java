package com.example.carbooking.contoller;

import com.example.carbooking.dto.LoginDto;
import com.example.carbooking.entities.RegisterEntity;
import com.example.carbooking.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    @PostMapping("/create")
    public ResponseEntity<RegisterEntity> createRegister(@RequestBody RegisterEntity registerEntity) {
        RegisterEntity savedEntity = registerService.create(registerEntity);
        return ResponseEntity.ok(savedEntity);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
        boolean isAuthenticated = registerService.login(loginDto);
        if (isAuthenticated) {
            return ResponseEntity.ok("Login successful!");
        } else {
            return ResponseEntity.status(401).body("Invalid email or password");
        }

    }
}