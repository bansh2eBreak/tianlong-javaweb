package com.nvyao.web;

import com.nvyao.pojo.Sect;
import com.nvyao.service.SectService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectAllSectsServlet")
public class SelectAllSectsServlet extends HttpServlet {
    private final SectService service = new SectService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.调用SectService完成sql查询
        List<Sect> sects = service.selectAll();
        //2.将List集合存入request域中
        request.setAttribute("sects", sects);
        //3.转发到sect.jsp
        request.getRequestDispatcher("/sects.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
