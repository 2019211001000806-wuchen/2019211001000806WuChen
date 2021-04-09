package com.wuchen.week3.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(
        urlPatterns = {"/register"}
        )
public class RegisterServlet extends HttpServlet {
  Connection con=null;
    public void init() throws ServletException{
        /*String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url="jdbc:sqlserver://localhost;DatabaseName=userdb;";
        String username="sa";
        String password="1339157058";
        try {
            Class.forName(driver);
            Connection con=DriverManager.getConnection(url,username,password);
            System.out.println("init()"+con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }*/
        con=(Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Username= request.getParameter("Username");
        String Password= request.getParameter("Password");
        String Email= request.getParameter("Email");
        String Gender= request.getParameter("Gender");
        String Birthdate= request.getParameter("Birthdate");
        PrintWriter writer=response.getWriter();

        try {
            String sql="insert into usertable "+"values('"+Username+"','"+Password+"','"+Email+"','"+Gender+"','"+Birthdate+"')";
            Statement st=con.createStatement();
            int n=st.executeUpdate(sql);
            System.out.println("n-->"+n);
          /* sql="select id,username,password,email,gender,birthdate from usertable";
           ResultSet rs=st.executeQuery(sql);
           PrintWriter out=response.getWriter();
           out.println("<html><title></title><body><table border=1><tr>");
           out.println("<td>Username</td><td>Password</td><td>Email</td><td>Gender</td><td>Birthdate</td>");
           while (rs.next()){
               out.println("<tr>");
               out.println("<td>"+rs.getString("username")+"</td>");
               out.println("<td>"+rs.getString("Password")+"</td>");
               out.println("<td>"+rs.getString("Email")+"</td>");
               out.println("<td>"+rs.getString("Gender")+"</td>");
               out.println("<td>"+rs.getString("Birthdate")+"</td>");
               out.println("</tr>");
           }
           out.println("</table></body></html>");
           */
           response.sendRedirect("login.jsp");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
