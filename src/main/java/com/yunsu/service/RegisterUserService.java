package com.yunsu.service;

import com.yunsu.domain.Register;
import com.yunsu.domain.User;

import javax.annotation.Resource;
import java.util.List;


public interface RegisterUserService {
    public void insertUser(Register reg);

    public Register findUserByName(String name);

    public void insertAddUser(User user);

    public List<User> findAll();

    public User findByName(String name);

    public void updateUser(User user);
}
