package project.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.modules.User;

import java.util.List;

@Repository
public interface UserDAO {
    User getUser(long userId);
    long addUser(User user);
    void deleteUser(long userId);
    void changeUser(User user);

    @Query("select user from User user")
    List<User> listUser();


}