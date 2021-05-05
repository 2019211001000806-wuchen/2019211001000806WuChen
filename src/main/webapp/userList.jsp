<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2021/5/4
  Time: 13:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<%@page import="java.sql.ResultSet" %>
<h1>User List</h1>
<table border=1>
    <tr>
        <td>Id</td><td>Username</td><td>Password</td><td>Email</td><td>Gender</td><td>Birthdate</td>
    </tr>
    <%
       ResultSet rs= (ResultSet) request.getAttribute("rsname");
       if (rs==null){
    %>
    <tr>
        <td>No Date!!!</td>
    </tr>
    <%}else {
           while (rs.next()){
    out.println("<tr>");
    out.println("<td>"+rs.getString("username")+"</td>");
    out.println("<td>"+rs.getString("Password")+"</td>");
    out.println("<td>"+rs.getString("Email")+"</td>");
    out.println("<td>"+rs.getString("Gender")+"</td>");
    out.println("<td>"+rs.getString("Birthdate")+"</td>");
    out.println("</tr>");
    }
        }%>
</table>
