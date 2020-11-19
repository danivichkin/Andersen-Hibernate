package DAO;


import entity.Role;

import java.sql.SQLException;
import java.util.List;

public interface RoleCRUD {
    void createRole(Role role);
    List<Role> readAllRoles();
    void updateById(Role role, String newRole);
    void deleteById(Role role);
}
