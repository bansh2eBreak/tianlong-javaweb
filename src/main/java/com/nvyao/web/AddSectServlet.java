package com.nvyao.web;

import com.nvyao.pojo.Sect;
import com.nvyao.service.SectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

@WebServlet("/addSectServlet")
public class AddSectServlet extends HttpServlet {
    private final SectService service = new SectService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接受门派id参数
        String name = request.getParameter("name");
        String introduction = request.getParameter("introduction");

        //3、乱码原因：tomcat进行URL解码的默认的字符集是ISO-8859-1
        //3.1 先对乱码数据进行编码，转为字节数组
        byte[] bytes1 = name.getBytes(StandardCharsets.ISO_8859_1);
        byte[] bytes2 = introduction.getBytes(StandardCharsets.ISO_8859_1);
        //3.2 将字节数组转换为字符串
        name = new String(bytes1, StandardCharsets.UTF_8);
        introduction = new String(bytes2, StandardCharsets.UTF_8);

        //2.封装门派Sect数据
        Sect sect = new Sect();
        sect.setName(name);
        sect.setIntroduction(introduction);
        // 使用 LocalDateTime 获取当前时间，并转换为 Date 类型
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println(currentTime);
        sect.setCreateTime(currentTime);
        sect.setUpdateTime(currentTime);
        //3.调用SectService完成sql执行
        service.add(sect);
        //4.删除完成后，完成跳转到查询所有业
        response.sendRedirect("/tianlong/selectAllSectsServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
