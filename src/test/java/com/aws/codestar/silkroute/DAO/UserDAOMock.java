package com.aws.codestar.silkroute.DAO;

import java.util.List;

import com.aws.codestar.silkroute.models.User;

public class UserDAOMock implements UserDAOI {

	public UserDAOMock() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public long createUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long createAdminUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteUserById(long userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deactivateUser(long userId) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean reactivateUser(long userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> adminGetAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean changeUserPassword(String encryptedPassword, long userId) {
		// TODO Auto-generated method stub
		return false;
	}

}
