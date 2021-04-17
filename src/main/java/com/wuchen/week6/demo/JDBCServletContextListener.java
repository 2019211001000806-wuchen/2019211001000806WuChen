package com.wuchen.week6.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet(name = "JDBCServletContextListener", value = "/JDBCServletContextListener")
public class JDBCServletContextListener implements ServletContextListener {
    public void contextDestroyed(ServletContextEvent event) {
        System.out.println("i am in contextDestroyed()");
        ServletContext context= event.getServletContext();
        context.removeAttribute("con");
    }
    public void contextInitialized(ServletContextEvent event) {
        ServletContext context= event.getServletContext();
        String driver= context.getInitParameter("driver");
        String url= context.getInitParameter("url");
        String username= context.getInitParameter("username");
        String password= context.getInitParameter("password");
        try {
            Class.forName(driver);
            try {
                Connection con= DriverManager.getConnection(url,username,password);
                System.out.println("i am in contextInitialized()-->con-->"+con);
                context.setAttribute("con",con);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }




}
