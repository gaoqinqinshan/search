package com.search.service.impl;

import com.search.dao.UserDao;
import com.search.entity.LoginUser;
import com.search.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 抛出异常（在用户不存在时）
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDao.queryOne(s);
        if (user == null) {
            throw new UsernameNotFoundException("该用户不存在");
        } else {
            return new LoginUser(user);
        }
    }
}
