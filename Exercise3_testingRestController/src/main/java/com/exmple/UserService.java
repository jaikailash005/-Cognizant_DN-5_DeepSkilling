package com.exmple;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public User getUserById(Long id) {
        return new User(id, "Mervyn");
    }
}