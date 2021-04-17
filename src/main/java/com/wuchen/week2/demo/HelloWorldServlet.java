package com.wuchen.week2.demo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorldServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        PrintWriter writer= response.getWriter();
        writer.println("Name:Wu Chen");
        writer.println("ID:2019211001000806");
        writer.println("Date and Time:Sat Match 13 15:23:02 CST 2021 ");
    }
}
