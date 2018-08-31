package com.aws.codestar.silkroute.DAO;

import java.sql.SQLException;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.*;
import java.sql.Connection;
import com.aws.codestar.silkroute.models.*;

public class PictureDAO extends AbstractDAO implements PictureDAOI{


@Override
public List<Picture> getAllUsersPics(long userId) {
   List<Picture> userPics = new ArrayList<Picture>();

   getConnection();
   try{
    PreparedStatement ps = conn.prepareStatement(SQL.GETALLUSERSPICS.getQuery());
    ps.setLong(1, userId);
    ResultSet rs = ps.executeQuery();
    while(rs.next()) {
        Picture row = new Picture();
        row.setPicture_id(rs.getLong(1));
        row.setImage(rs.getBlob(2));
        row.setOwner_id(rs.getLong(3));
        row.setCreation_date(rs.getDate(4));
        userPics.add(row);	
       }
}
catch(SQLException e){
    e.printStackTrace();
}
return userPics;
}

@Override
public boolean uploadPhotos(List<Picture> pics, long userId) {
    boolean itWorked = false;
    getConnection();
    try{
     PreparedStatement ps = conn.prepareStatement(SQL.UPLOADPHOTOS.getQuery());
     for(Picture pic: pics){
        ps.setBlob(1, pic.getImage() );
        ps.setLong(2,userId);
        itWorked = ps.executeUpdate() > 0 ? true : false;

        if(itWorked == false)
        break; //error 
     }
 }
 catch(SQLException e){
     e.printStackTrace();
 }

 return itWorked;
}


@Override
public boolean removePhoto(long picId) {
    boolean itWorked = false;
    getConnection();
    try{
     PreparedStatement ps = conn.prepareStatement(SQL.REMOVEPHOTOS.getQuery()); 
        ps.setLong(1,picId);
        itWorked = ps.executeUpdate() > 0 ? true : false;
    
 }
 catch(SQLException e){
     e.printStackTrace();
 }

 return itWorked;
}
}