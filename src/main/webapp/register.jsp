<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2021/3/13
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
This is my register JSP page.<br>
<form method="post" action="register">
    Username:<input type="text" name="Username" ><br>
    Password:<input type="password" name="Password"><br>
    Email:<input type="text" name="Email"><br>
    Gender:<input type="radio" value="Male">Male
    <input type="radio" value="Female">Female<br>
    Birthdate:<input type="text" name="Birthdate"><br>
    <input type="submit" value="register"><br>

</form>
<%@include file="footer.jsp"%>