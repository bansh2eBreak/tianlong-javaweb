package com.nvyao.web;

import com.nvyao.pojo.Hero;
import com.nvyao.service.HeroService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectAllHeroesServlet")
public class SelectAllHeroesServlet extends HttpServlet {
    private final HeroService service =  new HeroService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.调用SectService完成sql查询
        List<Hero> heroes = service.selectAll();
        //2.将List集合存入request域中
        request.setAttribute("heroes", heroes);
        //3.转发到sect.jsp
        request.getRequestDispatcher("/heroes.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
