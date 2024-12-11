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
    public String login(String username, String password){
        Optional<RegisterEntity> usernameoptional = registerRepository.findByUsername(username);
        if (usernameoptional != null){
            if (usernameoptional.get().getPassword()== password){
                return usernameoptional.get().getUsertype();
            }
        }
        return null;
    }
}
