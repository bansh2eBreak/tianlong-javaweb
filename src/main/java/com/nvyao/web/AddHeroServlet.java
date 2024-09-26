package com.nvyao.web;

import com.nvyao.pojo.Hero;
import com.nvyao.service.HeroService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

@WebServlet("/addHeroServlet")
public class AddHeroServlet extends HttpServlet {
    private final HeroService service = new HeroService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String kongfu = request.getParameter("kongfu");
        String gender = request.getParameter("gender");
        String level = request.getParameter("level");
        String birthdate = request.getParameter("birthdate");
        String sectId = request.getParameter("sectId");

        //3、乱码原因：tomcat进行URL解码的默认的字符集是ISO-8859-1
        //3.1 先对乱码数据进行编码，转为字节数组
        byte[] bytes1 = name.getBytes(StandardCharsets.ISO_8859_1);
        byte[] bytes2 = kongfu.getBytes(StandardCharsets.ISO_8859_1);
        //3.2 将字节数组转换为字符串
        name = new String(bytes1, StandardCharsets.UTF_8);
        kongfu = new String(bytes2, StandardCharsets.UTF_8);

        //2.封装门派Sect数据
        Hero hero = new Hero();
        hero.setUsername(username);
        hero.setPassword(password);
        hero.setName(name);
        hero.setKongfu(kongfu);
        hero.setGender(Short.parseShort(gender));
        hero.setLevel(Short.parseShort(level));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            hero.setBirthdate(dateFormat.parse(birthdate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        hero.setSectId(Integer.parseInt(sectId));

        // 使用 LocalDateTime 获取当前时间
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println(currentTime);
        hero.setCreateTime(currentTime);
        hero.setUpdateTime(currentTime);
        //3.调用SectService完成sql执行
        service.add(hero);
        //4.删除完成后，完成跳转到查询所有业
        response.sendRedirect("/tianlong/selectAllHeroesServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
