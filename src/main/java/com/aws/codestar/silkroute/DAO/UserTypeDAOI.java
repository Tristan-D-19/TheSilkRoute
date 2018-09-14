package com.aws.codestar.silkroute.DAO;
import com.aws.codestar.silkroute.models.*;
import java.util.List;


/**
 * UserTypeDAOI is an interface for getting user types from the table TSR_USER_TYPE
 */
public interface UserTypeDAOI { 

    
    enum SQL {
		GETUSERTYPES("SELECT * FROM TSR_ADMIN.TSR_USER_TYPE");
		
		String query;
		
		SQL(String givenQuery){
			query = givenQuery;
		}
		
		String getQuery() {
			return query;
        }

    }
    /**
     * getUserTypes gets all of the user types from the table TSR_USER_TYPE
     * @return a list of user types , type List
     */
    public List<Role> getUserTypes();
}