<%@ page import="com.wuchen.model.User" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2021/4/9
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Info</h1>
<%
    User user=(User) request.getAttribute("user");
%>
<table>
    <tr><td>Username:<%=user.getUsername()%></td></tr>
    <tr><td>Password:<%=user.getPassword()%></td></tr>
    <tr><td>Email:<%=user.getEmail()%></td></tr>
    <tr><td>Gender:<%=user.getGender()%></td></tr>
    <tr><td>Birthdate:<%=user.getBirthDate()%></td></tr>
</table>
<%@include file="footer.jsp"%>