package com.hsh.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xrkhy
 * @date 2025/9/10 0:08
 * @description
 */
@RestController
@RequestMapping("/vip")
public class VIPController {
    @RequestMapping("/getVIP")
    public String getVIP() {
        return "VIP用户，欢迎使用";
    }
}
