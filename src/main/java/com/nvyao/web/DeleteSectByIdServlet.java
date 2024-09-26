package com.nvyao.web;

import com.nvyao.service.SectService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteSectByIdServlet")
public class DeleteSectByIdServlet extends HttpServlet {
    private final SectService service = new SectService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接受门派id参数
        String id = request.getParameter("id");
        //2.调用SectService完成sql查询
        service.deleteById(Integer.parseInt(id));
        //3.删除完成后，完成跳转到查询所有业
        response.sendRedirect("/tianlong/selectAllSectsServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
