package com.wuchen.dao;

import com.wuchen.model.Product;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        return product;
    }

    @Override
    public List<Product> findByCategoryId(int categoryId, Connection con) {
        String sql="select * from product where CategoryId=?";
        PreparedStatement st= null;
        try {
            st = con.prepareStatement(sql);
            st.setInt(1, categoryId);
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

        return null;
    }

    @Override
    public List<Product> findByPrice(double minPrice, double maxPrice, Connection con) throws SQLException {
        String sql="select * from product where Price=?";
        PreparedStatement st= null;
        try {
            st = con.prepareStatement(sql);
            st.setDouble(1,minPrice);
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
        return null;
    }

    @Override
    public List<Product> findAll(Connection con) throws SQLException {
        String sql="select * from product ";
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

        return null;
    }

    @Override
    public List<Product> findByProductName(String productName, Connection con) throws SQLException {
        String sql="select * from product where ProductName=?";
        PreparedStatement st= null;
        try {
            st = con.prepareStatement(sql);
            st.setString(1,productName);
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
        return null;
    }

    @Override
    public List<Product> getPicture(Integer productId, Connection con) throws SQLException {

        return null;
    }
}
