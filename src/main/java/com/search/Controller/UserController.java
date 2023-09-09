package com.search.Controller;

import com.search.dao.UserDao;
import com.search.entity.TreeNode;
import com.search.entity.User;
import com.search.service.UserService;
import com.search.utils.RedisUtil_db0;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDao userDao;

    @Autowired
    private RedisUtil_db0 redisUtil;

    /**
     * 日志打印（一般放到最前面）
     */
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 判断用户是否存在
     *
     * @param username
     */
    @GetMapping(value = "/existUserName")
    public void existUserName(@RequestParam("username") String username) {
        boolean result = userService.checkUserName(username);
    }

    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    @CrossOrigin //解决跨域问题
    @PostMapping("/user/login")
    @ResponseBody //java 转 json 格式
    public Map<String, String> login(@RequestBody User user) {
        return userService.login(user);
    }

    /**
     * 注册
     *
     * @param user
     * @return
     */
    @PostMapping("/register")
    @ResponseBody
    public Map<String, String> register(@RequestParam User user) {
        Map<String, String> map = new HashMap<>();
        if (!userService.checkUserName(user.getUsername())) {
            logger.error("用户名已经存在");
            map.put("message", "userNameExist");
            return map;
        } else {
            int register = userService.register(user);
            if (register > 0) {
                map.put("message", "sueccess");
            } else {
                map.put("message", "failure");
            }
        }
        return map;
    }

    /**
     * 用户退出
     *
     * @param username
     * @param token
     * @return
     */
    @CrossOrigin
    @PostMapping("/user/login")
    @ResponseBody
    public Map<String, String> logout(@RequestParam("username") String username, @RequestParam("token") String token) {
        Map<String, String> rs = new HashMap<>();
        String tokenInRedis = userService.checkToken(username);
        if (token != null && token.equals(tokenInRedis)) {
            redisUtil.del("login" + userService.getUserByUsername(username).getId());
            rs.put("message", "success");
        }
        return rs;
    }

    /**
     * 判断token是否失效
     *
     * @param token
     * @param username
     * @return
     */
    public Map<String, String> checkJJwt(@RequestParam("token") String token, @RequestParam("username") String username) {
        Map<String, String> rs = new HashMap<>();
        String tokenInRedis = userService.checkToken(username);
        if (token.equals(tokenInRedis)) {
            rs.put("message", "success");
        } else {
            rs.put("message", "error");
        }
        return rs;
    }

    /**
     * 获取收藏
     *
     * @param username
     * @return
     */
    @GetMapping("/getFavorites")
    @ResponseBody
    public List<TreeNode> getFavorite(@RequestParam("username") String username) {
        return userService.getFavorite(username);
    }

    @PostMapping("/updateTreeNodeName")
    @ResponseBody
    public boolean updateTreeNodeNameById(@RequestBody Map<String, Object> params) {
        return userDao.updateTreeNodeNameById(params.get("newName").toString(), params.get("id").toString());
    }

    @PostMapping("/deleteTreeNode")
    @ResponseBody
    public boolean deleteTreeNodeById(@RequestBody Map<String, Object> params) {
        return userDao.deleteTreeNodeById(params.get("id").toString());
    }

    @PostMapping("/addTreeNode")
    @ResponseBody
    public boolean addTreeNode(@RequestBody Map<String, Object> params) {
        String userId = userDao.getUserIdByUsername(params.get("username").toString());
        String url = null;
        if (params.get("url") != null) {
            url = params.get("url").toString();
        }
        return userDao.addTreeNode(params.get("id").toString(),
                params.get("pid").toString(),
                params.get("name").toString(),
                params.get("isLeaf").toString().equals("1") ? true : false,
                userId,
                url);
    }
}
