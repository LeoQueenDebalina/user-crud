package com.myhotel.userservice.service;

import com.myhotel.userservice.entity.UserDatabase;
import com.myhotel.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImplement implements UserService {
    @Autowired
    private UserRepository userRepository;
        UUID uuid = UUID.randomUUID();
    @Override
    public List<UserDatabase> getUsers() {
        return userRepository.findAll();
    }

    public UserDatabase getUserByMNumber(String userPh) {
        Optional<UserDatabase> o = userRepository.findById(userPh);
        if (o.isPresent()){
            return o.get();
        }
        return null;
    }

    @Override
    public UserDatabase addUser(UserDatabase userDatabase) {
        return userRepository.save(userDatabase);
    }

    @Override
    public UserDatabase updateUser(UserDatabase userDatabase) {
        Optional<UserDatabase> o = userRepository.findById(userDatabase.getUserPh());
        if (o.isPresent()){
            return userRepository.save(userDatabase);
        }
        return null;
    }

    @Override
    public void deleteUser(String mnumber) {
        Optional<UserDatabase> o = userRepository.findById(mnumber);
        if (o.isPresent()){
            userRepository.deleteById(mnumber);
        }
    }
}