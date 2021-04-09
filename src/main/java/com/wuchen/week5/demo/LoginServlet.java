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
        con=(Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username= request.getParameter("username");
        String password= request.getParameter("password");
        PrintWriter out=response.getWriter();
        String sql="select username,password from usertable where username='"+username+"' and password='"+password+"'";
        try {
           ResultSet rs=con.createStatement().executeQuery(sql);
             if(rs.next()){
                 //out.println("Login Success!!!");
                 //out.println("Welcome"+username);
                 request.setAttribute("id",rs.getInt("id"));
                 request.setAttribute("username",rs.getString("username"));
                 request.setAttribute("password",rs.getString("password"));
                 request.setAttribute("email",rs.getString("email"));
                 request.setAttribute("gender",rs.getString("gender"));
                 request.setAttribute("birthdate",rs.getString("birthdate"));
                 request.getRequestDispatcher("userlist.jsp").forward(request,response);
             }
             else{
                 //out.println("Username or Password Error!!!");
                 request.setAttribute("message","Username or Password Error!!!");
                 request.getRequestDispatcher("login.jsp").forward(request,response);
             }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
