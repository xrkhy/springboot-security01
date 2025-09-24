package com.hsh.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xrkhy
 * @date 2025/9/10 0:08
 * @description
 */
@RestController
@RequestMapping("/noVIP")
public class NoVIPController {
    @RequestMapping("/getNoVIP")
    public String getNoVIP(){
        return "这是普通用户";
    }
}
