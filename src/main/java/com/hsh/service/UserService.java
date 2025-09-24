package com.hsh.service;

import com.hsh.pojo.User;
import com.hsh.pojo.dto.ResultJSON;

/**
 * @author xrkhy
 * @date 2025/9/8 22:05
 * @description
 */
public interface UserService {
    ResultJSON<User> login(String userName, String userPassword);
    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    ResultJSON getUserById(Long id);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    ResultJSON editUser(User user);

    /**
     *  删除用户
     * @param id
     * @return
     */
    ResultJSON deleteUser(Long id);

    /**
     * 添加用户
     * @param user
     * @return
     */
    ResultJSON addUser(User user);
}
