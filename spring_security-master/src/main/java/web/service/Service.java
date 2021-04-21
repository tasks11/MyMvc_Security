package web.service;

import web.model.Role;
import web.model.User;

import java.util.List;

@org.springframework.stereotype.Service
public interface Service {

    List<Role> getAllRole();
    List<User> getAllUser();
    User findByUsername(String name);
    void addUser(User user, String role);
    void deleteUser(User user);
    void editUser(User user, String role);
    User getById(long id);
    void init();
}
