package com.qiyao.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.qiyao.pojo.Result;
import com.qiyao.pojo.User;
import com.qiyao.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.qiyao.constant.UserConstant.USER_MAX_LENGTH;
import static com.qiyao.constant.UserConstant.USER_MIN_LENGTH;

/**
 * @ClassName UserController
 * @Description
 * @Version 1.0.0
 * @Author LinQi
 * @Date 2023/11/01
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(String username, String password) {
        // 非空校验
        if(StringUtils.isEmpty(username)  || StringUtils.isEmpty(password)){
            return Result.error("用户名和密码不能为空！");
        }
        if(username.length() < USER_MIN_LENGTH  || password.length() < USER_MIN_LENGTH ){
            return Result.error("用户名以及密码不能小于 5 位");
        }
        if(username.length() > USER_MAX_LENGTH || password.length() > USER_MAX_LENGTH){
            return Result.error("用户名以及密码不能大于 16 位");
        }
        // 查询用户
        User user = userService.findByUsername(username);

        // todo
        if(user == null){
            // 没有被注册，需要注册用户
            // 注册用户
            userService.register(username, password);
            return Result.success();
        }
        return Result.error("用户名已经注册了，请重新试试!");


    }
}
