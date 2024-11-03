package com.example.demo_exam.repository;

import com.example.demo_exam.entity.Country;
import com.example.demo_exam.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findAllByCountryNotOrderByAge(Country country);
}
