package com.example.demo_exam.service;


import com.example.demo_exam.entity.Country;
import com.example.demo_exam.entity.User;
import com.example.demo_exam.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.SequencedCollection;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public void addNewUser(User user){
        userRepository.save(user);
    }

    public List<User> customMethod(Country country){
        return userRepository.findAllByCountryNotOrderByAge(country);
    }

}
