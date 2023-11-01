package com.qiyao.mapper;

import com.qiyao.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @ClassName UserMapper
 * @Description
 * @Version 1.0.0
 * @Author LinQi
 * @Date 2023/11/01
 */
@Mapper
public interface UserMapper {
    /**
     * 根据用户名查询用户
     * @param username 用户名
     * @return
     */
    @Select("select * from user where username=#{username}")
    User findByUsername(String username);

    /**
     * 添加用户
     * @param username 用户名
     * @param password md5字符串
     */
    @Insert("insert into user(username,password,create_time,update_time)"+
            "values( #{username}, #{password},now(),now())")
    void add(String username, String password);
}
