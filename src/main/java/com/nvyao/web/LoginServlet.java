package com.nvyao.web;

import com.nvyao.pojo.User;
import com.nvyao.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    private final UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、接收用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //获取复选框-是否记住密码
        String remember = request.getParameter("remember");

        //获取用户输入的验证码：
        String checkCode = request.getParameter("checkCode");

        //获取服务端生成的验证吗
        HttpSession session = request.getSession();
        String checkCodeGen = (String) session.getAttribute("checkCodeGen");

        //校验验证码
        if(!checkCodeGen.equalsIgnoreCase(checkCode)){
            //不允许注册
            request.setAttribute("register_msg","验证码错误");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }

        //2、调用service去查询
        User user = service.login(username, password);
        //3、判断
        if(user != null){
            //判断用户的状态是否是启用
            if (user.getIsEnable() == 0) {
                // 用户被禁用，提示用户已禁用
                request.setAttribute("login_msg", "用户已被禁用，请联系管理员");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
                return;
            }

            //判断用户是否勾选记住我
            if("1".equals(remember)){
                //勾选了，发送cookie
                //1、创建cookie对象
                Cookie c_username = new Cookie("username",username);
                Cookie c_password = new Cookie("password",password);
                //设置cookie存活时间
                c_username.setMaxAge(60 * 60 * 24 * 7);
                c_password.setMaxAge(60 * 60 * 24 * 7);

                //2、发送
                response.addCookie(c_username);
                response.addCookie(c_password);
            }

            //将登录成功的user对象，存储到session
            // 改了这里这里这里
            session.setAttribute("user",user);
            String contextPath = request.getContextPath();
            //登录成功
            response.sendRedirect(contextPath + "/selectAllHeroesServlet");
        }else{
            //登陆失败
            request.setAttribute("login_msg","用户名或密码错误");
            //跳转到login.jsp
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
