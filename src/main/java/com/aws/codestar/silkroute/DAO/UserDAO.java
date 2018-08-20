package com.aws.codestar.silkroute.DAO;
import com.aws.codestar.silkroute.models.*;
import java.util.List;

public class UserDAO extends AbstractDAO implements UserDAOI {


    @Override
    public User createUser(User user) {
        getConnection();
        
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    @Override
    public User getUserById(long userId) {
        return null;
    }

    @Override
    public boolean deactivateUser(long userId) {
        return false;
    }

    @Override
    public boolean deleteUserById(long userId) {
        return false;
    }

    @Override
    public List<User> adminGetAllUsers(long userId) {
        return null;
    }

    @Override
    public User createAdminUser(User user) {
        return null;
    }

    @Override
    public boolean changeUserPassword(String encryptedPassword, long userId) {
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }
}