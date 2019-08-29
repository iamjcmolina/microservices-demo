package com.example.userservice.service;

import com.example.userservice.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
    User save(User user);
    User findById(Long id);
    User update(Long id, User user);
    User delete(Long id);
    User restore(Long id);
}
