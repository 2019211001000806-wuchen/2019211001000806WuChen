package com.wuchen.week4.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        urlPatterns = {"/config"},
        initParams = {
                @WebInitParam(name="name",value = "wuchen"),
                @WebInitParam(name="studentid",value = "2019211001000806")
        },loadOnStartup = 1
)

public class ConfigDemoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=getServletConfig().getInitParameter("name");
        String studentid=getServletConfig().getInitParameter("studentid");
        PrintWriter writer= response.getWriter();
        writer.println("name:"+name);
        writer.println("studentid:"+studentid);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
