package com.example.carbooking.service;

import com.example.carbooking.entities.UserEntity;
import com.example.carbooking.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {


    public final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity create(UserEntity userEntity){
        return userRepository.save(userEntity);
    }

    public Object getById(int id){
        Optional<UserEntity> FindById = userRepository.findByCustomerid(id);
        if (FindById.isPresent()){
            return userRepository.findByCustomerid(id);
        }
        return null;
    }
    }


