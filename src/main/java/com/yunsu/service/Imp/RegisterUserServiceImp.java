package com.yunsu.service.Imp;

import com.alibaba.fastjson.JSON;
import com.yunsu.dao.RegisterUserDao;
import com.yunsu.domain.Register;
import com.yunsu.domain.User;
import com.yunsu.service.RegisterUserService;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class RegisterUserServiceImp implements RegisterUserService{
    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private RegisterUserDao registerUserDao;

    @Override
    public void insertUser(Register reg) {
        registerUserDao.insertRegisterUser(reg);
        redisTemplate.opsForValue().set(reg.getUname(), JSON.toJSONString(reg));
    }

    @Override
    public Register findUserByName(String name) {
        String str = (String) redisTemplate.opsForValue().get(name);
        Register register = JSON.parseObject(str, Register.class);
        System.out.println(register.toString());
        if(register != null){
            return register;
        }
        Register reg = registerUserDao.findUserByName(name);
        if(reg != null){
            redisTemplate.opsForValue().set(name, JSON.toJSONString(reg));
        }
        return reg;
    }

    @Override
    public void insertAddUser(User user) {
        registerUserDao.insertAddUser(user);
        redisTemplate.opsForValue().set(user.getUname(), JSON.toJSONString(user));
    }

    @Override
    public List<User> findAll() {
        return registerUserDao.findAll();
    }

    @Override
    public User findByName(String name) {
        return registerUserDao.findByName(name);
    }

    @Override
    public void updateUser(User user) {
        registerUserDao.updateUser(user);
    }
}
