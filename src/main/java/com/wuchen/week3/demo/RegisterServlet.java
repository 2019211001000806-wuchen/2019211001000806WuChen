package com.wuchen.week3.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Username= request.getParameter("Username");
        String Password= request.getParameter("Password");
        String Email= request.getParameter("Email");
        String Gender= request.getParameter("Gender");
        String Birthdate= request.getParameter("Birthdate");
        PrintWriter writer= response.getWriter();
        writer.println("<br>Username:"+Username);
        writer.println("<br>Password:"+Password);
        writer.println("<br>Email:"+Email);
        writer.println("<br>Gender:"+Gender);
        writer.println("<br>Birthdate:"+Birthdate);
        writer.close();
    }
}
