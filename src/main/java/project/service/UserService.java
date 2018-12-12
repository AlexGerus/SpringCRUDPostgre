package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.dao.UserDAOImpl;
import project.modules.User;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserDAOImpl dao;

    public UserService() {
    }

    @Transactional
    public long addUser(User user) {
        return dao.addUser(user);
    }

    @Transactional
    public void changeUser(User user) {
        dao.changeUser(user);
    }

    @Transactional
    public void deleteUser(long userId) {
        dao.deleteUser(userId);
    }

    @Transactional
    public User getUser(long userId) {
        return dao.getUser(userId);
    }

    @Transactional
    public List<User> listUser() {
        return dao.listUser();
    }
}