package com.zhoutc.springmvc.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * Created by zhoutc on 2016/6/23.
 */
public class LoginFilter extends HttpServlet implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        // 登陆页面无需过滤
        String path = request.getRequestURI();
        System.out.println(path);
        if (path.indexOf("/v1/session/test") < 0) {
            HttpSession session = request.getSession(true);
            String username = (String) session.getAttribute("username");//登录人角色
            String url = request.getRequestURI();
            if (username == null || "".equals(username)) {
                //判断获取的路径不为空且不是访问登录页面或执行登录操作时跳转
                response.getWriter().write("please login");
                return;

            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
        return;
    }
}
