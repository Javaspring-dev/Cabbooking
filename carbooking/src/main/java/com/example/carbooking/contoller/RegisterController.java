package com.example.carbooking.contoller;

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
    @GetMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody String username, @RequestBody String password){
        return ResponseEntity.ok(registerService.login(username,password));
    }
}