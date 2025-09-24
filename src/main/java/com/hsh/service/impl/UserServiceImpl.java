package com.hsh.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hsh.mapper.UserMapper;
import com.hsh.pojo.User;
import com.hsh.pojo.dto.ResultJSON;
import com.hsh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xrkhy
 * @date 2025/9/8 22:05
 * @description
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public ResultJSON login(String userCode, String userPassword) {
        User user = userMapper.login(userCode, userPassword);
        if (user != null) {
            return ResultJSON.success(user);
        }
        return null;
    }
    @Override
    public ResultJSON getUserById(Long id) {
        User user = userMapper.selectById(id);
        return ResultJSON.success(user);
    }

    @Override
    public ResultJSON editUser(User user) {
        int i = userMapper.updateById(user);
        return ResultJSON.successORerror(i);
    }

    @Override
    public ResultJSON deleteUser(Long id) {
        int i = userMapper.deleteById(id);
        return ResultJSON.successORerror(i);
    }

    @Override
    public ResultJSON addUser(User user) {
        int i = userMapper.insert(user);
        return ResultJSON.successORerror(i);
    }
}
