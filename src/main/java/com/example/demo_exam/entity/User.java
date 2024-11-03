package com.example.demo_exam.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "users") //  user?
@Data
@AllArgsConstructor
@RequiredArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "first_name")
    String firstName;
    @Column(name = "age")
    Integer age;
    @Enumerated(EnumType.STRING)
   // @Enumerated(EnumType.STRING);
    @Column(name = "country")
    Country country;
}
