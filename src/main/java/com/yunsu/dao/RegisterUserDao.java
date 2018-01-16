package com.yunsu.dao;

import com.yunsu.domain.Register;
import com.yunsu.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  RegisterUserDao {
    public void insertRegisterUser(Register reg);

    public Register findUserByName(String name);

    public void insertAddUser(User user);

    public List<User> findAll();

    public User findByName(String name);

    public void updateUser(User user);
}
