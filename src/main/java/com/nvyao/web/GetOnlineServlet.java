package com.nvyao.web;

import com.nvyao.web.listener.SessionCounterListener;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/getonline")
public class GetOnlineServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("当前在线人数：" + SessionCounterListener.getActiveSessions());

        // 设置响应内容类型为 JSON
        response.setContentType("application/json");
        // 创建一个 JSON 格式的字符串表示在线用户数
        String jsonResponse = "{\"onlineUsers\": " + SessionCounterListener.getActiveSessions() + "}";

        // 将 JSON 响应发送回客户端
        try (PrintWriter out = response.getWriter()) {
            out.println(jsonResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
