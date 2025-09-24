package com.hsh.controller;

import com.hsh.pojo.User;
import com.hsh.pojo.dto.ResultJSON;
import com.hsh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xrkhy
 * @date 2025/9/8 22:11
 * @description
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/getUserById")
    public ResultJSON getUserById(Long id){
        return ResultJSON.success(userService.getUserById(id));
    }

}
