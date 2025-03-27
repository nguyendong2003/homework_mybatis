package com.example.homework.service;

import com.example.homework.model.User;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    boolean existsByUsername(String username);
    void saveUser(User user);
}
