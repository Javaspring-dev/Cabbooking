package com.example.carbooking.service;

import com.example.carbooking.dto.LoginDto;
import com.example.carbooking.entities.RegisterEntity;
import com.example.carbooking.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegisterService {
    @Autowired
    private RegisterRepository registerRepository;

    public  RegisterEntity create(RegisterEntity registerEntity){

        return registerRepository.save(registerEntity);
    }
    public boolean login(LoginDto loginDto) {
        Optional<RegisterEntity> registerEntity = registerRepository.findByUsername(loginDto.getUsername());
        return registerEntity.isPresent() && registerEntity.get().getPassword().equals(loginDto.getPassword());
    }



}
