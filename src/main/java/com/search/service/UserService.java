package com.search.service;

import com.search.entity.User;

import java.util.Map;

public interface UserService {

    /**
     * 获取tokebn
     */
    String checkToken(String username);

    /**
     * 获取登录的name
     */
    boolean checkUserName(String username);

    /**
     * 获取注册
     */
    int register(User user);

    /**
     * 登录
     */
    Map<String, String> login(User user);

    /**
     * 获取登录者的名字
     */
    User getUserByUsername(String username);

/**
 * 获取收藏
 */
}
