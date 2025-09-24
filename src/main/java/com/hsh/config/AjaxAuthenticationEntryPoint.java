package com.hsh.config;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xrkhy
 * @date 2025/9/10 9:29
 * @description
 */
public class AjaxAuthenticationEntryPoint{
//    @Override
//    public void commence(HttpServletRequest httpServletRequest,
//                         HttpServletResponse httpServletResponse, AuthenticationException e) throws
//            IOException, ServletException {
//        String msgName = httpServletRequest.getAttribute("msgName").toString();
//        MassageJson massageJson = new MassageJson();
//        if (msgName.equals("未登录")){
//            massageJson.setCode(001);
//            massageJson.setMsg("未登录");
//        } else if (msgName.equals("权限不足")){
//            massageJson.setCode(002);
//            massageJson.setMsg("权限不足");
//        } else{
//            massageJson.setCode(003);
//            massageJson.setMsg("系统异常");
//        }
//        httpServletResponse.setCharacterEncoding("utf-8");
//        httpServletResponse.getWriter().write(JSON.toJSONString(massageJson));
//    }

}
