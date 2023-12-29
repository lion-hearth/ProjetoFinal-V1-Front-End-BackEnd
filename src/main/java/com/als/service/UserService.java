package com.als.service;

import com.als.entity.User;



public interface UserService {
    void saveUser(User user);
    User findByUsername(String username);
    boolean authenticate(String username, String password);
}
