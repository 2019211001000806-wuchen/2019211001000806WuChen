<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2021/4/9
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Info</h1>
<table>
    <tr><td>Username:<%=request.getAttribute("username")%></td></tr>
    <tr><td>Password:<%=request.getAttribute("Password")%></td></tr>
    <tr><td>Email:<%=request.getAttribute("Email")%></td></tr>
    <tr><td>Gender:<%=request.getAttribute("Gender")%></td></tr>
    <tr><td>Birthdate:<%=request.getAttribute("Birthdate")%></td></tr>
</table>
<%@include file="footer.jsp"%>