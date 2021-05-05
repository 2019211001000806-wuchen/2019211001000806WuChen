package com.wuchen.week5.demo;

import com.wuchen.dao.UserDao;
import com.wuchen.model.User;


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

        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username= request.getParameter("username");
        String password= request.getParameter("password");
        PrintWriter out=response.getWriter();
        UserDao userdao=new UserDao();
        User user= null;
        try {
            user = userdao.findByUsernamePassword(con,username,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if(user!=null){
            String rememberMe=request.getParameter("rememberMe");
            if(rememberMe!=null && rememberMe.equals("1")){
                Cookie usernameCookie=new Cookie("cUsername",user.getUsername());
                Cookie passwordCookie=new Cookie("cPassword",user.getPassword());
                Cookie rememberMeCookie=new Cookie("cRememberMe",request.getParameter("rememberMe"));
                usernameCookie.setMaxAge(5);
                passwordCookie.setMaxAge(5);
                rememberMeCookie.setMaxAge(5);
                response.addCookie(usernameCookie);
                response.addCookie(passwordCookie);
                response.addCookie(rememberMeCookie);
            }
            HttpSession session=request.getSession();
            System.out.println("session id-->"+session.getId());
            session.setMaxInactiveInterval(10);
            session.setAttribute("user",user);
            request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
        }else{
            request.setAttribute("message","Username or Password Error!!!");
            request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
        }

    }
}
