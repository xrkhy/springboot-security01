package com.hsh.security;

import com.hsh.mapper.UserMapper;
import com.hsh.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @author xrkhy
 * @date 2025/9/9 23:22
 * @description
 */
@Component
public class LoginAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private UserMapper userMapper;
    @Override
    public Authentication authenticate(Authentication authentication) throws
            AuthenticationException {
        String userName = (String) authentication.getPrincipal(); //拿到username
        String password = (String) authentication.getCredentials(); //拿到password
        System.out.println("userName========" + userName);
        System.out.println("password========" + password);
        //调用service层 连接数据库 返回登录对象 此处忽略
        User user = userMapper.login(userName, password);
        //判断是否登录 未登录不进入
        if (user != null) {
            // 1. 设置的权限必须以 ROLE开头
            // 2. 多个权限可使用, 隔开 输出结果是集合对象 [ROLE_ADMIN,ROLE_USER]
            Collection<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
            // new UsernamePasswordAuthenticationToken(认证, 加密, 鉴权)
            return new UsernamePasswordAuthenticationToken(user, user.getUserPassword(), authorities);
        }
        /*验证不通过*/
        return null;
    }

    /**
     * 如果该AuthenticationProvider支持传入的Authentication对象，则返回true
     *
     * @param aClass
     * @return
     */
    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }

}
