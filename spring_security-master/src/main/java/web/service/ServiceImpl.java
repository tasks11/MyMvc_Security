package web.service;

import web.dao.Dao;
import web.model.Role;
import web.model.User;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

    private final Dao dao;

    public ServiceImpl(Dao dao) {
        this.dao = dao;
    }

    @Transactional
    @Override
    public List<Role> getAllRole() {
        return dao.getAllRole();
    }

    @Transactional
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
        Role roleUser = new Role(role);
        Set<Role> set = new HashSet<>();
        set.add(roleUser);
        user.setRoles(set);
        dao.addUser(user);
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
       dao.deleteUser(id);
    }

    @Transactional
    @Override
    public void editUser(User user, String role) {
        Role roleUser = new Role(role);
        Set<Role> set = new HashSet<>();
        set.add(roleUser);
        user.setRoles(set);
        dao.editUser(user);
    }

    @Transactional
    @Override
    public User getById(long id) {
        return dao.getById(id);
    }

//    private User intermediate(User user, String role, Set<Role> set) {
//        if (role_3.getRole().equals(role)) {
//            set.add(role_1);
//            set.add(role_2);
//            user.setRoles(set);
//        }
//        if (role_1.getRole().equals(role)) {
//            set.add(role_1);
//            user.setRoles(set);
//        }
//        if (role_2.getRole().equals(role)) {
//            set.add(role_2);
//            user.setRoles(set);
//        }
//        return user;
//    }

    @Transactional
    @Override
    public void init() {
        Role role_1 = new Role("ROLE_ADMIN");
        Role role_2 = new Role("ROLE_USER");
        dao.addRoles(role_1);
        dao.addRoles(role_2);
        addUser(new User("1", "1"), role_1.getRole());
        addUser(new User("2", "2"), role_2.getRole());
        addUser(new User("3", "3"), role_2.getRole());
    }

}
