package web.dao;

import web.model.Role;
import web.model.User;

import java.util.List;

public interface Dao {

    List<Role> getAllRole();
    List<User> getAllUser();
    User findByUsername(String name);
    void addUser(User user);
    void addRoles(Role role);
    void deleteUser(User user);
    void editUser(User user);
    User getById(long id);
}
