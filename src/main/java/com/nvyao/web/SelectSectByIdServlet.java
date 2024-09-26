package com.nvyao.web;

import com.nvyao.pojo.Sect;
import com.nvyao.service.SectService;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/selectSectByIdServlet")
public class SelectSectByIdServlet extends HttpServlet {

    private final SectService service = new SectService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Sect sect = service.selectById(Integer.parseInt(id));
        request.setAttribute("sect", sect);
        request.getRequestDispatcher("/updateSect.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
