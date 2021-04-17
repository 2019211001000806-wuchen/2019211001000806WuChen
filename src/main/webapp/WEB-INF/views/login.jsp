<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2021/4/1
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<%
    if (!(request.getAttribute("message")==null)){
        out.print("<h3>"+request.getAttribute("message")+"</h3>");

    }
%>
<form method="post" action="login">
    Username:<input type="text" name="Username"><br>
    Password:<input type="password" name="Password"><br>
    <input type="submit" value="login"><br>

</form>
<%@include file="footer.jsp"%>