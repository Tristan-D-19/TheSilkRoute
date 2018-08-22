package com.aws.codestar.silkroute.DAO;
import com.aws.codestar.silkroute.models.*;
import java.util.List;



public interface DepartmentDAOI {


    enum SQL {
		GETALLDEPARTMENTS("SELECT * FROM TSR_ADMIN.TSR_DEPARTMENT"),
		GETDEPARTMENTBYID("SELECT * FROM TSR_ADMIN.TSR_DEPARTMENT WHERE DEP_ID=?");
		
		String query;
		
		SQL(String givenQuery){
			query = givenQuery;
		}
		
		String getQuery() {
			return query;
		}
    }
    

    /**
     * getAtllDepartments gets all of the departments
     * @return A list of all deparments 
     */
    public List<Department> getAllDepartments();


    /**
     * getDepartmentById gets the department by the ID
     * @param departmentId the department's ID
     * @return a department <type Department>
     */
    public Department getDepartmentById(long depatmentId);
}