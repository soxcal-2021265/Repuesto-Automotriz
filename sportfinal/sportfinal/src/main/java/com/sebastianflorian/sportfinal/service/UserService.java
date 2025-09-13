package com.sebastianflorian.sportfinal.service;

import com.sebastianflorian.sportfinal.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Integer id);
    User saveUser(User user);
    User updateUser(Integer id, User user);
    void deleteUser(Integer id);
}
