package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import web.dao.Dao;
import web.model.Role;
import web.model.User;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

    private final Role role_1 = new Role("ROLE_ADMIN");
    private final Role role_2 = new Role("ROLE_USER");
    private final Role role_3 = new Role("ROLE_ADMIN,ROLE_USER");
    private final User user = new User("1", "1");
    private final User user2 = new User("2", "2");
    private final User user3 = new User("3", "3");

    private final Dao dao;

    public ServiceImpl(Dao dao) {
        this.dao = dao;
    }

    @Override
    public List<Role> getAllRole() {
        return dao.getAllRole();
    }

    @Override
    public List<User> getAllUser() {
        return dao.getAllUser();
    }

    @Override
    public User findByUsername(String name) {
        return dao.findByUsername(name);
    }

    @Transactional
    @Override
    public void addUser(User user, String role) {
        Set<Role> set = new HashSet<>();
        User user1 = intermediate(user, role, set);
        dao.addUser(user1);
    }

    @Transactional
    @Override
    public void deleteUser(User user) {
        dao.deleteUser(user);
    }

    @Override
    public void editUser(User user, String role) {

    }

    @Transactional
    @Override
    public User getById(long id) {
        return dao.getById(id);
    }

    private User intermediate(User user, String role, Set<Role> set) {
        if (role_3.getRole().equals(role)) {
            set.add(role_1);
            set.add(role_2);
            user.setRoles(set);
        }
        if (role_1.getRole().equals(role)) {
            set.add(role_1);
            user.setRoles(set);
        }
        if (role_2.getRole().equals(role)) {
            set.add(role_2);
            user.setRoles(set);
        }
        return user;
    }

    @Transactional
    @Override
    public void init() {
        dao.addRoles(role_1);
        dao.addRoles(role_2);
        addUser(user, role_3.getRole());
        addUser(user2, role_2.getRole());
        addUser(user3, role_2.getRole());
    }

}
