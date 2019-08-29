package com.example.userservice.dao;

import com.example.userservice.entity.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();
    User save(User user);
    User findById(Long id);
    User update(Long id, User user);
    User delete(Long id);
    User restore(Long id);
    Integer countPostsByUserId(Long id);
}
