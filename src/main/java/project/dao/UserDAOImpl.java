package project.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.modules.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    private EntityManager em;

    public UserDAOImpl() {}

    @Transactional
    public long addUser(User user) {
        em.persist(user);
        return user.getUserId();
    }

    @Transactional
    public void changeUser(User user) {
        User newUser = getUser(user.getUserId());
        newUser.setUserId(user.getUserId());
        newUser.setUserName(user.getUserName());
        newUser.setUserAge(user.getUserAge());
        em.merge(newUser);
    }

    @Transactional
    public void deleteUser(long userId) {
        User user = getUser(userId);
        em.remove(user);
    }

    @Transactional
    public User getUser(long userId) {
        return em.find(User.class, userId);
    }

    @Transactional
    public List<User> listUser() {
        return em.createQuery("select user from User user").getResultList();
    }
}