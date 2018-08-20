package com.aws.codestar.silkroute.DAO;
import com.aws.codestar.silkroute.models.*;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 * UserTypeDAO is an Data access object to retrieve user types from the database
 */
public class UserTypeDAO extends AbstractDAO implements UserTypeDAOI{ 

    
@Override
public List<UserType> getUserTypes() {
    List<UserType> user_types = new ArrayList<UserType>();
    getConnection();
    
    try {
        PreparedStatement ps = conn.prepareStatement(SQL.GETUSERTYPES.getQuery());
       
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
           UserType userType = new UserType();
           userType.setType_id(rs.getLong(1));
           userType.setType_name(rs.getString(2));
          user_types.add(userType);
        }
    } catch (SQLException e) {
        
        e.printStackTrace();
    } finally {
        closeConnection();
    }
    
    return user_types;
    
}

}