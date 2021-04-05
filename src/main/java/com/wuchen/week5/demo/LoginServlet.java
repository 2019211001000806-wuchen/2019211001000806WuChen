package com.wuchen.week5.demo;

import javax.naming.Context;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext context=getServletConfig().getServletContext();
        String driver= context.getInitParameter("driver");
        String url= context.getInitParameter("url");
        String username= context.getInitParameter("username");
        String password= context.getInitParameter("password");
        try {
            Class.forName(driver);
            try {
                con= DriverManager.getConnection(url,username,password);
                System.out.println(con);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username= request.getParameter("username");
        String password= request.getParameter("password");
        response.setContentType("");
        PrintWriter out=response.getWriter();
        try {
            ResultSet rs=con.createStatement().executeQuery("select * from usertable where username='"+username+"' and password='"+password+"'");
             if(username!=""){
                 out.println("Login Success!!!");
                 out.println("Welcome"+username);
             }
             else{out.println("Username or Password Error!!!");}


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
