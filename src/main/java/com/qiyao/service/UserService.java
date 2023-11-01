package com.qiyao.service;

import com.qiyao.pojo.User;

/**
 * @InterfaceName UserService
 * @Description
 * @Version 1.0.0
 * @Author LinQi
 * @Date 2023/11/01
 */
public interface UserService {
    /**
     * 根据用户名查询用户
     * @param username 用户名
     * @return 查询到用户名的用户信息
     */
    User findByUsername(String username);

    /**
     * 注册用户
     * @param username 注册用户名
     * @param password 用户密码
     */
    void register(String username, String password);
}
