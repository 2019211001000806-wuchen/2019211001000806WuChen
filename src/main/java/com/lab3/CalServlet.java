package com.lab3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalServlet", value = "/CalServlet")
public class CalServlet extends HttpServlet {
    private int add(int firstVal,int secondVal){
        return  firstVal+secondVal;
    }
    private int subtract(int firstVal,int secondVal){

        return  firstVal-secondVal;
    }
    private int multiply(int firstVal,int secondVal){

        return  firstVal*secondVal;
    }
    private int divide(int firstVal,int secondVal){
        return  firstVal/secondVal;
    }
    private int computeLength(String String){
        return String.length();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstVal = request.getParameter("firstVal");
        String secondVal = request.getParameter("secondVal");
        String name=request.getParameter("name");
        if(request.getParameter("computerLength") != null){
            int length=computeLength(name);
            Cookie c1=new Cookie("cName",name);
            Cookie c2=new Cookie("cLength",Integer.toString(length));
            response.addCookie(c1);
            response.addCookie(c2);
        }else{
        int n1=Integer.valueOf(firstVal);
        int n2=Integer.valueOf(secondVal);
        int cResult=0;
        if(request.getParameter("add") != null){
            cResult=add(n1,n2);
        }else if(request.getParameter("subtract") != null){
            cResult=subtract(n1,n2);
        }else if(request.getParameter("multiply") != null){
            cResult=multiply(n1,n2);
        }else if(request.getParameter("divide") != null){
            cResult=divide(n1,n2);
        }
        Cookie c3=new Cookie("cFirstValue",Integer.toString(n1));
        Cookie c4=new Cookie("cSecondValue",Integer.toString(n2));
        Cookie c5=new Cookie("cResult",Integer.toString(cResult));
        response.addCookie(c3);
        response.addCookie(c4);
        response.addCookie(c5);
    }
        response.sendRedirect("http://localhost:8080/demo_war_exploded/lab3/cal.jsp");
    }
}
