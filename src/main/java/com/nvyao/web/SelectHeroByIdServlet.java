package com.nvyao.web;

import com.nvyao.pojo.Hero;
import com.nvyao.service.HeroService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/selectHeroByIdServlet")
public class SelectHeroByIdServlet extends HttpServlet {

    private final HeroService service = new HeroService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Hero hero = service.selectById(Integer.parseInt(id));
        System.out.println(hero);
        request.setAttribute("hero", hero);
        request.getRequestDispatcher("/updateHero.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
