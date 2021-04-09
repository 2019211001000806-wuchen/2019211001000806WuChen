package com.wuchen.week6.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet( urlPatterns = {"/search"}
      )
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String txt = request.getParameter("txt");
        String search = request.getParameter("search");
        if (txt == "") {
            response.sendRedirect("index.jsp");
        } else {
            if ("baidu".equals(search)) {
                response.sendRedirect("https://www.baidu.com/s?wd=" + txt);
            } else if ("bing".equals(search)) {
                response.sendRedirect("https://cn.bing.com/search?q=" + txt);
            } else if ("google".equals(search)) {
                response.sendRedirect("https://www.google.com/search?q=" + txt);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}