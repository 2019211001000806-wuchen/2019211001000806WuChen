package com.wuchen.controller;

import com.wuchen.dao.ProductDao;
import com.wuchen.model.Category;
import com.wuchen.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

@WebServlet(name = "ShopServlet", value = "/shop")
public class ShopServlet extends HttpServlet {
    Connection con=null;
    public void init() throws  ServletException{
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Category category=new Category();
        try {
            List<Category> categoryList=Category.findAllCategory(con);
            request.setAttribute("categoryList",categoryList);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        ProductDao productDao=new ProductDao();
        List<Product> productList=null;
        try {
            if(request.getParameter("categoryId")==null){
             productList=productDao.findAll(con);

            }else {
                int catId=Integer.parseInt(request.getParameter("categoryId"));
                productList=productDao.findByCategoryId(catId,con);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("productList",productList);
        String path="WEB-INF/views/shop.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
