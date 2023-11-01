package com.qiyao.service.impl;

import com.qiyao.mapper.UserMapper;
import com.qiyao.pojo.User;
import com.qiyao.service.UserService;
import com.qiyao.utils.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceIMpl
 * @Description
 * @Version 1.0.0
 * @Author LinQi
 * @Date 2023/11/01
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUsername(String username) {
        User user = userMapper.findByUsername(username);
        return user;
    }

    @Override
    public void register(String username, String password) {
        // 加密处理
        String md5String = Md5Utils.getMD5String(password);
        // 添加
        userMapper.add(username,md5String);
    }
}
