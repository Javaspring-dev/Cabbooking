package com.example.carbooking.contoller;

import com.example.carbooking.dto.LoginDto;

import com.example.carbooking.entities.RegisterEntity;
import com.example.carbooking.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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
    public ResponseEntity<Object> login(@RequestBody LoginDto loginDto) {
        try {
            String userType = registerService.login(loginDto);

            String token = userType.equalsIgnoreCase("driver")
                    ? "dummy-driver-token-123"
                    : "dummy-user-token-456";
            Map<String, String> response = new HashMap<>();
            response.put("message", "Login successful");
            response.put("userType", userType);
            response.put("token", token);

            return ResponseEntity.ok(response);

        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }
}