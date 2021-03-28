package com.wuchen.week3.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(
        urlPatterns = {"/register"},
        initParams = {
                @WebInitParam(name = "Username", value = ""),
                @WebInitParam(name="Password",value = ""),
                @WebInitParam(name="Email",value = ""),
                @WebInitParam(name="Gender",value = ""),
                @WebInitParam(name="Birthdate",value = "")
        }
        )
public class RegisterServlet extends HttpServlet {
  Connection con=null;
    public void init() throws ServletException{
        String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url="jdbc:sqlserver://localhost:1433;DatabaseName=userdb";
        String username="sa";
        String password="1339157058";
        try {
            Class.forName(driver);
            Connection con=DriverManager.getConnection(url,username,password);
            System.out.println("init()"+con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
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
        String sql="insert into usertable values('2019211001000806','wuchen','123@qq.com','male','1999-09-09')";
        try {
            ResultSet rs=con.createStatement().executeQuery(sql);
            while (rs.next()){
             writer.println();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
