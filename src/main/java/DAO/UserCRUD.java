package DAO;

import entity.Role;
import entity.User;

import java.sql.SQLException;
import java.util.List;


public interface UserCRUD {
    void create(User user);
    List<User> readAllUsers();
    List<User> readAllUsersByRole(Role role);
    void updateUserById(User user, String newName);
    void deleteUserById(User user);
    void addNewRoleToUser(User user, Role role);
}
