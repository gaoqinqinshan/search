package com.search.service.impl;

import com.search.dao.UserDao;
import com.search.entity.LoginUser;
import com.search.entity.User;
import com.search.service.UserService;
import com.search.utils.JwtUtil;
import com.search.utils.RedisUtil_db0;
import com.search.utils.RedisUtil_db1;
import io.jsonwebtoken.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RedisUtil_db0 redisUtil;

    //用户不存在直接抛出
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    /**
     * 获取token，并且把token放到redis里面
     *
     * @param username
     * @return
     */
    @Override
    public String checkToken(String username) {
        User user = userDao.queryOne(username);
        String token = (String) redisUtil.get("login" + user.getId());
        return token;
    }

    /**
     * 检查name是否存在
     *
     * @param username
     * @return
     */
    @Override
    public boolean checkUserName(String username) {
        User user = userDao.queryOne(username);
        return user == null;
    }

    /**
     * 获取 id pawword
     *
     * @param user
     * @return
     */
    @Override
    public int register(User user) {
        user.setId(UUID.randomUUID().toString().replace("-", ""));
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return userDao.insertOne(user);
    }

    /**
     * 用户登录阶段
     *
     * @param user
     * @return
     */
    @Override
    public Map<String, String> login(User user) {
        Map<String, String> rs = new HashMap<>();
        //用户认证
        LoginUser userDetails = (LoginUser) userDetailsService.loadUserByUsername(user.getUsername());

        //判断认证是否通过
        if (passwordEncoder.matches(user.getPassword(), userDetails.getPassword())) {

            //认证通过
            //通过userID生成jwt放到redis里面
            User datailsUser = userDetails.getUser();
            String id = datailsUser.getId();
            String jwt = JwtUtil.createJWT("ouerTeam", 1000 * 60 * 60 * 10, id);

            rs.put("token", jwt);
            rs.put("username", datailsUser.getUsername());
            rs.put("message", "success");

            redisUtil.set("login" + datailsUser.getId(), jwt, 60 * 60 * 6);
            return rs;
        } else {
            rs.put("message", "failure");
            return rs;
        }
    }

    /**
     * 获取登录name
     *
     * @param username
     * @return
     */
    @Override
    public User getUserByUsername(String username) {
        return userDao.queryOne(username);
    }
}
