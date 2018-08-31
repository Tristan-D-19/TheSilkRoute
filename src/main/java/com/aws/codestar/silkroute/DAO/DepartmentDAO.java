package com.aws.codestar.silkroute.DAO;
import java.sql.SQLException;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.*;
import java.sql.Connection;
import com.aws.codestar.silkroute.models.*;

public class DepartmentDAO extends AbstractDAO implements DepartmentDAOI{

    @Override
    public List<Department> getAllDepartments() {
        List<Department> deparments = new ArrayList<Department>();

        getConnection();
		try{
			PreparedStatement ps = conn.prepareStatement(SQL.GETALLDEPARTMENTS.getQuery());
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
                Department row = new Department();
                
				row.setDepartment_id(rs.getLong(1));
                row.setDepartment_name(rs.getString(2));
                row.setDescription(rs.getString(3));
				deparments.add(row);
			}

		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return deparments;
    }

    @Override
    public Department getDepartmentById(long depatmentId) {
        Department department = new Department();
        getConnection();
		try{
			PreparedStatement ps = conn.prepareStatement(SQL.GETALLDEPARTMENTS.getQuery());
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
              
                
				department.setDepartment_id(rs.getLong(1));
                department.setDepartment_name(rs.getString(2));
                department.setDescription(rs.getString(3));
				
			}

		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return department;
    }
}