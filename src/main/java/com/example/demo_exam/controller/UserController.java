package com.example.demo_exam.controller;

import com.example.demo_exam.entity.Country;
import com.example.demo_exam.entity.User;
import com.example.demo_exam.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("user-api/v1")
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> findAllUsers() {
        var users = userService.findAllUsers();
        return users != null ?
                ResponseEntity.ok(users) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("/users")
    public ResponseEntity<User> addNewUser(@RequestBody User user) {
        try {
            userService.addNewUser(user);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity("New user created with id: " + user.getId(), HttpStatus.CREATED);
    }

    @GetMapping("/additional-info/{country}")
    public ResponseEntity<List<User>> customMethod(@PathVariable("country") String country) {
        try {
            var countryChecked = Country.valueOf(country);
            var resp = userService.customMethod(countryChecked);
            if(resp != null) return ResponseEntity.ok(resp);
            else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
