package com.burak.tasklist.service;

import com.burak.tasklist.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
    User save(User user);
    void deleteById(Long id);
    User findById(Long id);
    User findByUsername(String name);
}
