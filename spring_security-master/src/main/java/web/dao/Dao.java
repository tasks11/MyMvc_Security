package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Role;
import web.model.User;

import java.util.List;

@Repository
public interface Dao {

    List<Role> getAllRole();
    List<User> getAllUser();
    User findByUsername(String name);
    void addUser(User user);
    void addRoles(Role role);
    void deleteUser(Long id);
    void editUser(User user);
    User getById(long id);
}
