package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import web.dao.Dao;
import web.model.Role;
import web.model.User;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

    @Autowired
    Dao dao;

    @Override
    public List<Role> getAllRole() {
        return null;
    }

    @Override
    public List<User> getAllUser() {
        return null;
    }

    @Override
    public User findByUsername(String name) {
        return null;
    }

    @Override
    public void addUser(User user, String role) {

    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public void editUser(User user, String role) {

    }

    @Override
    public User getById(long id) {
        return null;
    }

    @Override
    public void init() {

    }
}
