package com.schoolmanagement.controller;

import java.time.LocalDate;

import com.schoolmanagement.entity.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String subject;
    
    @Column(name = "hire_date")
    private LocalDate hireDate;
    
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}

