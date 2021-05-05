package com.wuchen.week3.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(
        urlPatterns = {"/register"},loadOnStartup = 1
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
        super.init();
        /*String driver = getServletContext().getInitParameter("driver");
        String url = getServletContext().getInitParameter("url");
        String username = getServletContext().getInitParameter("username");
        String password = getServletContext().getInitParameter("password");
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("-->" + con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }*/
        con=(Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.getRequestDispatcher("WEB-INF/views/register.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username= request.getParameter("username");
        String password= request.getParameter("password");
        String email= request.getParameter("email");
        String gender= request.getParameter("gender");
        String birthdate= request.getParameter("birthdate");
        PrintWriter writer=response.getWriter();

        try {
            Statement st=con.createStatement();
            String sql="insert into usertable "+"values('"+username+"','"+password+"','"+email+"','"+gender+"','"+birthdate+"')";
            System.out.println("sql"+sql);

            int n=st.executeUpdate(sql);
            System.out.println("n-->"+n);
          //sql="select id,username,password,email,gender,birthdate from usertable";
           //ResultSet rs=st.executeQuery(sql);
           //PrintWriter out=response.getWriter();
          /* out.println("<html><title></title><body><table border=1><tr>");
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

            //request.setAttribute("rsname",rs);
            //request.getRequestDispatcher("userList.jsp").forward(request,response);
           response.sendRedirect("login");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
