package com.schoolmanagement.service;

import java.util.Optional;

import com.schoolmanagement.entity.User;

public interface UserService {
    
    public Optional<User> findByUsername(String username);
       
}

