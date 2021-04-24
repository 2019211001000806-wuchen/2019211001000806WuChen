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
Cookie [] allCookies=request.getCookies();
for (Cookie c:allCookies){
    out.println("<br/>"+c.getName()+"---"+c.getValue());
}
%>
<%
    User u=(User) session.getAttribute("user");
%>
<table>
    <tr><td>Username:<%=u.getUsername()%></td></tr>
    <tr><td>Password:<%=u.getPassword()%></td></tr>
    <tr><td>Email:<%=u.getEmail()%></td></tr>
    <tr><td>Gender:<%=u.getGender()%></td></tr>
    <tr><td>Birthdate:<%=u.getBirthDate()%></td></tr>
    <tr>
        <a href="updateUser">Update User</a>
    </tr>
</table>
<%@include file="footer.jsp"%>