package com.search.service.impl;

import com.search.dao.UserDao;
import com.search.entity.User;
import com.search.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    //用户不存在直接抛出
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Override
    public String checkToken(String username) {
        return null;
    }

    @Override
    public boolean checkUserName(String username) {
        return false;
    }

    @Override
    public int register(User user) {
        return 0;
    }

    @Override
    public Map<String, String> login(User user) {
        return null;
    }

    @Override
    public User getUserByUsername(String username) {
        return null;
    }
}
