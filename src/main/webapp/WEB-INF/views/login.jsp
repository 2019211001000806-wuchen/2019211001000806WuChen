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
<%
    Cookie[] allCookies=request.getCookies();
    String username="",password="",rememberMeVal="";
    if (allCookies!=null){
        for (Cookie c:allCookies){
            if (c.getName().equals("cUsername")){
                username=c.getValue();
            }
            if (c.getName().equals("cPassword")){
                password=c.getValue();
            }
            if (c.getName().equals("crememberMeVal")){
                rememberMeVal=c.getValue();
            }
        }
    }
%>
<form method="post" action="login">
    Username:<input type="text" name="username" value="<%=username%>"><br/>
    Password:<input type="password" name="password" value="<%=password%>"><br/>
    <input type="checkbox" name="rememberMe" value="1" <%= rememberMeVal.equals("1") ?"checked":""%>/>Remember Me<br/>
    <input type="submit" value="login"/><br/>

</form>
<%@include file="footer.jsp"%>