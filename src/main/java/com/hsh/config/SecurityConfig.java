package com.hsh.config;

import com.hsh.security.LoginAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.annotation.Resource;

/**
 * @author xrkhy
 * @date 2025/9/9 22:47
 * @description
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    //实例化过滤器
    @Resource
    private LoginAuthenticationProvider provider;
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //登录调用provider
        auth.authenticationProvider(provider);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http// 关闭csrf防护 关闭防护后才能操作security
            .csrf().disable()
            .headers().frameOptions().disable()
            .and();
        http  //登录处理
            .formLogin() //表单方式，或httpBasic
            .loginPage("/login.html") //自定义登录页面
            .loginProcessingUrl("/userLogin") //表单提交路径
            .usernameParameter("uname")// 自定义用户名参数,也就是前端交给后端的参数 默认 username
            .passwordParameter("pwd")// 自定义密码参数,也就是前端交给后端的参数 默认 password
            .defaultSuccessUrl("/user/getUserById?id=1") //成功登陆后跳转页面
            .permitAll(); //放行以上路径
        // 权限控制 当我们登录成功后得去配置权限控制 控制用户访问的页面
        http.authorizeRequests()
                .antMatchers("/").permitAll() //放行这个请求
                .antMatchers("/user").hasAnyRole("ADMIN", "USER")//ADMIN和USER角色都可以访问
                .antMatchers("/vip/**").hasRole("ADMIN") //admin下的页面需要 ADMIN这个角色才可以访问
                .antMatchers("/noVIP/**").hasAnyRole("USER", "ADMIN"); //USER和ADMIN角色都可以访问
    }
}
