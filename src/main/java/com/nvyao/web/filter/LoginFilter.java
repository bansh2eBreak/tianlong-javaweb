package com.nvyao.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录验证过滤器
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        System.out.println("LoginFilter被执行....");
        HttpServletRequest req = (HttpServletRequest) request;
        //判断访问资源路径是否和登录注册相关
        String[] urls = {"/login.jsp","/imgs/","/images/","/css/","/loginServlet","/register.jsp","/registerServlet","/checkCodeServlet"};
        //获取当前访问的资源路径
        String url = req.getRequestURL().toString();
//        System.out.println("当前url是：" + url);
        //循环判断
        for (String u : urls) {
            if(url.contains(u)){
                //找到了，放行
                chain.doFilter(request, response);
                return;
            }
        }

        //1、判断session中是否有user
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");

        //2、判断user是否为null
        if(user != null){
            //登录，放行
            chain.doFilter(request, response);
        }else{
            //未登录，存储提示信息，跳转到登录页面
            req.setAttribute("login_msg","您尚未登录");
            req.getRequestDispatcher("/login.jsp").forward(req, response);
        }
    }

    @Override
    public void destroy() {

    }
}
