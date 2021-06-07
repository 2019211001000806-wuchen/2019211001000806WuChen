package com.wuchen.controller;


import com.wuchen.dao.UserDao;
import com.wuchen.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

@WebServlet(name = "UpdateUserServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    Connection con=null;
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
        request.getRequestDispatcher("accountDetails").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username= request.getParameter("username");
        String password= request.getParameter("password");
        String Email= request.getParameter("Email");
        String Gender= request.getParameter("Gender");
        String Birthdate= request.getParameter("Birthdate");
        UserDao userdao=new UserDao();
        User user=null;
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(Email);
        user.setGender(Gender);
        user.setBirthDate(Birthdate);
        try {
            int u=userdao.updateUser(con,user);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("user",user);
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request,response);
    }
}
