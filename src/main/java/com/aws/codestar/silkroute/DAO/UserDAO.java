package com.aws.codestar.silkroute.DAO;
import com.aws.codestar.silkroute.models.*;
import java.util.List;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.io.*;
import java.sql.Connection;

/**
 * UserDAO allows access to users from the table TSR_USERS
 */
public class UserDAO extends AbstractDAO implements UserDAOI {

//---------------------------------------------------------------------------

    @Override
    public long createUser(User user) {
        boolean itWorked = false;
        long userGenKey = 0;
        
        getConnection();
        try{
        PreparedStatement ps = conn.prepareStatement(SQL.CREATEUSER.getQuery(),  new String[]
        { "USER_ID" });
        ResultSet rs = null;
        ps.setString(1, user.getEmail());
        ps.setString(2, user.getFirst_name());
        ps.setString(3, user.getLastname());
        ps.setString(4, user.getPassword());
        itWorked = (ps.executeUpdate() > 0) ? true : false;
        if(itWorked)
          {
         rs = ps.getGeneratedKeys();  
          }
          if (rs != null && rs.next() && itWorked) 
            {
                userGenKey = rs.getInt(1);
            }   
    } catch (SQLException e) {
       
        e.printStackTrace();
    } finally {
        closeConnection();
    }
        
        return userGenKey;
    }
  //---------------------------------------------------------------------------

    @Override
    public List<User> getAllUsers() {
    	List<User> users = new ArrayList<User>();
    	
    	
   	 getConnection();
        try{
        PreparedStatement ps = conn.prepareStatement(SQL.GETALLUSERS.getQuery());
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()) {
        	User row = new User();
        	row.setEmail(rs.getString(1));
			row.setFirstname(rs.getString(2));
			row.setZipcode(rs.getInt(3));
			row.setProfilePic(rs.getLong(4));
			users.add(row);	
			}
    } catch (SQLException e) {
       
        e.printStackTrace();
    } finally {
        closeConnection();
    }
        return users;
    }
  //---------------------------------------------------------------------------

    @Override
    public User getUserByEmail(String email) {
    	 User row = new User();
    	 getConnection();
         try{
         PreparedStatement ps = conn.prepareStatement(SQL.GETUSERBYEMAIL.getQuery());
         ps.setString(1, email);
         ResultSet rs = ps.executeQuery();
         
         if(rs.next()) {
				
				row.setId(rs.getLong(1));
				row.setIs_active(rs.getBoolean(2));
				row.setEmail(rs.getString(3));
				row.setFirstname(rs.getString(4));
				row.setLastname(rs.getString(5));
				row.setPassword(rs.getString(6));
				row.setDate_joined(rs.getDate(7));
				row.setAddress(rs.getString(8));
				row.setCity(rs.getString(9));
				row.setState(rs.getString(10));
				row.setZipcode(rs.getInt(11));
				row.setPhone(rs.getInt(12));
				row.setUser_type(rs.getInt(13));
				row.setProfilePic(rs.getLong(14));
				
				
			}
         else {
        	 System.err.println("ERROR NADA!");
         }
     } catch (SQLException e) {
        
         e.printStackTrace();
     } finally {
         closeConnection();
     }
         
         
         return row;
    }
  //---------------------------------------------------------------------------

    @Override
    public User getUserById(long userId) {
    	 User row = new User();
    	 getConnection();
    
         try{
         PreparedStatement ps = conn.prepareStatement(SQL.GETUSERBYID.getQuery());
         ps.setLong(1, userId);
         ResultSet rs = ps.executeQuery();
         
         if(rs.next()) {
				
        	 	row.setId(rs.getLong(1));
				row.setIs_active(rs.getBoolean(2));
				row.setEmail(rs.getString(3));
				row.setFirstname(rs.getString(4));
				row.setLastname(rs.getString(5));
				row.setPassword(rs.getString(6));
				row.setDate_joined(rs.getDate(7));
				row.setAddress(rs.getString(8));
				row.setCity(rs.getString(9));
				row.setState(rs.getString(10));
				row.setZipcode(rs.getInt(11));
				row.setPhone(rs.getInt(12));
				row.setUser_type(rs.getInt(13));
				row.setProfilePic(rs.getLong(14));
				
				
			}
     } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
         finally {
         closeConnection();
     }
                  
         return row;
    }
  //---------------------------------------------------------------------------

    @Override
    public boolean deactivateUser(long userId) {
    	 boolean itWorked = false;
    	 getConnection();
         try{
         PreparedStatement ps = conn.prepareStatement(SQL.DEACTIVATEUSER.getQuery());
         ps.setLong(1, userId);
         itWorked = ps.executeUpdate() > 0 ? true : false;
         
       
     } catch (SQLException e) {
        
         e.printStackTrace();
     } finally {
         closeConnection();
     }
    	
    	return itWorked;
        
    }
  //---------------------------------------------------------------------------

    @Override
    public boolean reactivateUser(long userId) {
    	 boolean itWorked = false;
    	 getConnection();
         try{
         PreparedStatement ps = conn.prepareStatement(SQL.REACTIVATEUSER.getQuery());
         ps.setLong(1, userId);
         itWorked = ps.executeUpdate() > 0 ? true : false;
         
       
     } catch (SQLException e) {
        
         e.printStackTrace();
     } finally {
         closeConnection();
     }
    	
    	return itWorked;
        
    }  
    
  //---------------------------------------------------------------------------

    @Override
    public boolean deleteUserById(long userId) {
    	 boolean itWorked = false;
    	 getConnection();
         try{
         PreparedStatement ps = conn.prepareStatement(SQL.DELETEUSERBYID.getQuery());
         ps.setLong(1, userId);
         itWorked = ps.executeUpdate() > 0 ? true : false;
         
       
     } catch (SQLException e) {
        
         e.printStackTrace();
     } finally {
         closeConnection();
     }
    	
    	return itWorked;
        
    }
  //---------------------------------------------------------------------------

    @Override
    public List<User> adminGetAllUsers() {
    	List<User> users = new ArrayList<User>();
    	
    	
    	 getConnection();
         try{
         PreparedStatement ps = conn.prepareStatement(SQL.ADMINGETALLUSERS.getQuery());
         ResultSet rs = ps.executeQuery();
         
         while(rs.next()) {
        	 User row = new User();
        	 	row.setId(rs.getLong(1));
				row.setIs_active(rs.getBoolean(2));
				row.setEmail(rs.getString(3));
				row.setFirstname(rs.getString(4));
				row.setLastname(rs.getString(5));
				row.setPassword(rs.getString(6));
				row.setDate_joined(rs.getDate(7));
				row.setAddress(rs.getString(8));
				row.setCity(rs.getString(9));
				row.setState(rs.getString(10));
				row.setZipcode(rs.getInt(11));
				row.setPhone(rs.getInt(12));
				row.setUser_type(rs.getInt(13));
				row.setProfilePic(rs.getLong(14));
				users.add(row);	
			}
     } catch (SQLException e) {
        
         e.printStackTrace();
     } finally {
         closeConnection();
     }
         return users;
    }
  //---------------------------------------------------------------------------

    @Override
    public long createAdminUser(User user) {
    	  boolean itWorked = false;
          long userGenKey = 0;
          
          getConnection();
          try{
          PreparedStatement ps = conn.prepareStatement(SQL.CREATEUSER.getQuery(),  new String[]
          { "USER_ID" });
          ResultSet rs = null;
          ps.setString(1, user.getEmail());
          ps.setString(2, user.getFirst_name());
          ps.setString(3, user.getLastname());
          ps.setString(4, user.getPassword());
          itWorked = ps.executeUpdate() > 0 ? true : false;
          if(!itWorked)
            {
           rs = ps.getGeneratedKeys();  
            }
            if (rs != null && rs.next() && itWorked) 
              {
                  userGenKey = rs.getInt(1);
              }   
      } catch (SQLException e) {
         
          e.printStackTrace();
      } finally {
          closeConnection();
      }
          
          return userGenKey;
    }
  //---------------------------------------------------------------------------

    @Override
    public boolean changeUserPassword(String encryptedPassword, long userId) {
    	  boolean itWorked = false;
         
          
          getConnection();
          try{
          PreparedStatement ps = conn.prepareStatement(SQL.CHANGEUSERPASSWORD.getQuery());
         
          ps.setString(1, encryptedPassword);
          ps.setLong(2, userId);
         
          itWorked = ps.executeUpdate() > 0 ? true : false;
        
      } catch (SQLException e) {
         
          e.printStackTrace();
      } finally {
          closeConnection();
      }
          
          return itWorked;
    }
//---------------------------------------------------------------------------
    @Override
    public boolean updateUser(User user) {
    	  boolean itWorked = false;
          
          getConnection();
          try{
          PreparedStatement ps = conn.prepareStatement(SQL.CREATEUSER.getQuery());
          
          
          ps.setString(1, user.getEmail());
          ps.setString(2, user.getFirst_name());
          ps.setString(3, user.getLastname());
          ps.setString(4, user.getAddress());
          ps.setString(5, user.getCity());
          ps.setString(6, user.getState());
          ps.setInt(7, user.getZipcode());
          ps.setInt(8, user.getPhone());
          ps.setLong(9, user.getProfilePic());
          
          
          itWorked = ps.executeUpdate() > 0 ? true : false;
        
           
      } catch (SQLException e) {
         
          e.printStackTrace();
      } finally {
          closeConnection();
      }
          
          return itWorked;
    }
}