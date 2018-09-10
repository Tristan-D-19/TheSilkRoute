package com.aws.codestar.silkroute.DAO;
import java.sql.SQLException;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.*;
import java.sql.Connection;
import java.sql.Date;

import com.aws.codestar.silkroute.models.*;

public class OrderDAO extends AbstractDAO implements OrderDAOI {

    @Override
    public List<Order> getAllUsersOrdersById(long userId) {
       List <Order> orders = new ArrayList<Order>();

       getConnection();
       try{
        PreparedStatement ps = conn.prepareStatement(SQL.GETALLUSERSORDERSBYID.getQuery());
        ps.setLong(1,userId);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Order row = new Order( rs.getLong(2), rs.getDate(3));
            row.setOrderId(rs.getLong(1));
            row.setShippingDate(rs.getDate(4));
            row.setOrderPrice(rs.getDouble(5));
            orders.add(row);
        }

    }
    catch(SQLException e){
        e.printStackTrace();
    }
    return orders;
    }


    @Override
    public Order getOrderById(long orderId) {
        Order order = null;
        getConnection();
        try{
         PreparedStatement ps = conn.prepareStatement(SQL.GETALLUSERSORDERSBYID.getQuery());
         ps.setLong(1,orderId);
         ResultSet rs = ps.executeQuery();
         while(rs.next()){
             order = new Order( rs.getLong(2), rs.getDate(3));
             order.setOrderId(rs.getLong(1));
             order.setShippingDate(rs.getDate(4));
             order.setOrderPrice(rs.getDouble(5));
         }
 
     }
     catch(SQLException e){
         e.printStackTrace();
     }
     return order;
    }

    @Override
    public List<Order> getOrdersByDate(Date date) {
        List <Order> orders = new ArrayList<Order>();

        getConnection();
        try{
         PreparedStatement ps = conn.prepareStatement(SQL.GETALLUSERSORDERSBYID.getQuery());
         ps.setDate(1,date);
         ResultSet rs = ps.executeQuery();
         while(rs.next()){
             Order row = new Order( rs.getLong(2), rs.getDate(3));
             row.setOrderId(rs.getLong(1));
             row.setShippingDate(rs.getDate(4));
             row.setOrderPrice(rs.getDouble(5));
             orders.add(row);
         }
 
     }
     catch(SQLException e){
         e.printStackTrace();
     }
     return orders;
    }
}