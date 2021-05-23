package com.wuchen.dao;

import com.wuchen.model.Product;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ProductDao implements  IProductDao{
    @Override
    public int save(Product product, Connection con) throws SQLException {
        int n = 0;
        String sql = "insert into product(ProductName,ProductDescription,Picture,price,CategoryID) values(?,?,?,?,?)";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, product.getProductName());
        pt.setString(2, product.getProductDescription());
        if(product.getPicture()!=null) {
            //for sql server
            pt.setBinaryStream(3, product.getPicture());
            //for mysql
            //   pt.setBlob(3, product.getPicture());
        }
        pt.setDouble(4, product.getPrice());
        pt.setInt(5, product.getCategoryId());
        n = pt.executeUpdate();
        if (n > 0) {
            return n;
        }
        return 0;
    }//end save

    @Override
    public int delete(Integer productId, Connection con) {
        String sql="delete from product where productId=?";
        PreparedStatement st= null;
        try {
            st = con.prepareStatement(sql);
            st.setInt(1,productId);
            st.executeUpdate(sql);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Product product=null;
        ResultSet rs= null;
        try {
            rs = st.executeQuery();
            if(rs.next()) {
                product.setProductId(rs.getInt("productId"));
                product.setProductName(rs.getString("productName"));
                product.setProductDescription(rs.getString("productDescription"));
                product.setPicture(rs.getAsciiStream("picture"));
                product.setPrice(rs.getDouble("price"));
                product.setCategoryId(rs.getInt("categoryId"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return 0;
    }

    @Override
    public int update(Product instance, Connection con) {
        String sql="update  product set productName=? where productId=?";
        PreparedStatement st= null;
        try {
            st = con.prepareStatement(sql);
            st.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Product product=null;
        ResultSet rs= null;
        try {
            rs = st.executeQuery();
            if(rs.next()) {
                product.setProductId(rs.getInt("productId"));
                product.setProductName(rs.getString("productName"));
                product.setProductDescription(rs.getString("productDescription"));
                product.setPicture(rs.getAsciiStream("picture"));
                product.setPrice(rs.getDouble("price"));
                product.setCategoryId(rs.getInt("categoryId"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    @Override
    public Product findById(Integer productId, Connection con) {
        String sql="select * from product where productId=?";
        PreparedStatement st= null;
        try {
            st = con.prepareStatement(sql);
            st.setInt(1,productId);
            st.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Product product=null;
        ResultSet rs= null;
        try {
            rs = st.executeQuery();
            while(rs.next()) {
                product.setProductId(rs.getInt("productId"));
                product.setProductName(rs.getString("productName"));
                product.setProductDescription(rs.getString("productDescription"));
                product.setPicture(rs.getAsciiStream("picture"));
                product.setPrice(rs.getDouble("price"));
                product.setCategoryId(rs.getInt("categoryId"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> findByCategoryId(int categoryId, Connection con) {

        List<Product> list=new ArrayList<Product>();
        try {
            String sql="select * from product where CategoryId=?";
            PreparedStatement st= con.prepareStatement(sql);
            st.setInt(1, categoryId);
            ResultSet rs=st.executeQuery();
            while (rs.next()) {
                Product product=new Product();
                product.setProductId(rs.getInt("productId"));
                product.setProductName(rs.getString("productName"));
                product.setProductDescription(rs.getString("productDescription"));
                product.setPrice(rs.getDouble("price"));
                product.setCategoryId(rs.getInt("categoryId"));
                list.add(product);
            }
            System.out.println("successful");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Product> findByPrice(double minPrice, double maxPrice, Connection con) throws SQLException {
        List<Product> list=new ArrayList<Product>();
        try {
            String sql="select * from product where price=?";
            PreparedStatement st= con.prepareStatement(sql);
            st.setDouble(1,maxPrice);
            ResultSet rs=st.executeQuery();
            while (rs.next()) {
                Product product=new Product();
                product.setProductId(rs.getInt("productId"));
                product.setProductName(rs.getString("productName"));
                product.setProductDescription(rs.getString("productDescription"));
                product.setPrice(rs.getDouble("price"));
                product.setCategoryId(rs.getInt("categoryId"));
                list.add(product);
            }
            System.out.println("successful");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Product> findAll(Connection con) throws SQLException {
        List<Product> list=new ArrayList<Product>();
        try {
            String sql="select * from product ";
            PreparedStatement st= con.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            while (rs.next()) {
                Product product=new Product();
                product.setProductId(rs.getInt("productId"));
                product.setProductName(rs.getString("productName"));
                product.setProductDescription(rs.getString("productDescription"));
                product.setPrice(rs.getDouble("price"));
                product.setCategoryId(rs.getInt("categoryId"));
                list.add(product);
            }
            System.out.println("successful");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Product> findByProductName(String productName, Connection con) throws SQLException {

        List<Product> list=new ArrayList<Product>();
        try {
            String sql="select * from product where ProductName=?";
            PreparedStatement st= con.prepareStatement(sql);
            st.setString(1,productName);
            ResultSet rs=st.executeQuery();
            while (rs.next()) {
                Product product=new Product();
                product.setProductId(rs.getInt("productId"));
                product.setProductName(rs.getString("productName"));
                product.setProductDescription(rs.getString("productDescription"));
                product.setPrice(rs.getDouble("price"));
                product.setCategoryId(rs.getInt("categoryId"));
                list.add(product);
            }
            System.out.println("successful");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Product> getPicture(Integer productId, Connection con) throws SQLException {

        return null;
    }
    public byte[] getPictureById(Integer productId,Connection con) throws SQLException{
        byte[] imgBytes=null;
        String sql="select picture from product where productId=?";
        PreparedStatement st= con.prepareStatement(sql);
        st.setInt(1,productId);
        ResultSet rs=st.executeQuery();
        while (rs.next()){
            Blob blob= rs.getBlob("picture");
            imgBytes=blob.getBytes(0,(int)blob.length());
        }
        return imgBytes;
    }

}
