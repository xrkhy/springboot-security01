package com.hsh.config;

import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xrkhy
 * @date 2025/9/10 9:22
 * @description
 */
@Component("rbacauthorityservice")
public class RbacAuthorityService {
    @Resource
    // 这里应该引入springframework的包
    private Environment env;
    /**
     * 返回false时 调用AjaxAuthenticationEntryPoint类
     * @param request
     * @param authentication
     * @return
     */
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        // 获取当前请求的URI
        String requestURI = request.getServletPath();
        // 放开登录url
        if (requestURI.equals("/admin/login")) {
            return true;
        }
        // 登录判断
        String token = request.getHeader("userToken");
        //token需要到redis中找 找不到也是未登录
        System.out.println(token);
        if (token == null) {
            request.setAttribute("flagName", "未登录");
            return false;
        }
        // 权限判断 利用token获取用户登录对象 获取角色ID 通过角色ID到redis中找角色对应 的权限集合
        // 利用token去Redis取出当前角色的权限,这里就直接写死了
        List<String> roles = new ArrayList<>();
        roles.add("/admin/list");
        roles.add("/admin/menu");
        if (!roles.contains(requestURI)) {
            request.setAttribute("flagName", "权限不足");
            return false;
        }
        return true;
    }
}
