package com.example.carbooking.service;

import com.example.carbooking.Exception.ConflictException;
import com.example.carbooking.dto.LoginDto;
import com.example.carbooking.entities.RegisterEntity;
import com.example.carbooking.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class RegisterService {

    @Autowired
    private RegisterRepository registerRepository;

    public  RegisterEntity create(RegisterEntity registerEntity){
        Optional<RegisterEntity>username=registerRepository.findByUsername(registerEntity.getUsername());
        if(username.isPresent()){
            throw new ConflictException("user already exists");
        }
        return registerRepository.save(registerEntity);
    }
    public Map<String, Object> login(LoginDto loginDto) {
        Optional<RegisterEntity> registerEntity = registerRepository.findByUsername(loginDto.getUsername());
        if (registerEntity.isEmpty()) {
            throw new ConflictException("User not found");
        }
        if (!registerEntity.get().getPassword().equals(loginDto.getPassword())) {
            throw new ConflictException("Invalid password");
        }
        RegisterEntity user = registerEntity.get();
        Map<String, Object> response = new HashMap<>();
        response.put("id", user.getId());
        response.put("userType", user.getUsertype());
        response.put("username", user.getUsername());

        return response;
    }

}
