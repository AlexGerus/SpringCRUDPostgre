package project.modules;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users_table", schema = "petshop")
public class User implements Serializable {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_age")
    private int userAge;

    @OneToMany(mappedBy = "user")
    private Set<Role> userRoles = new HashSet<>();


    public User() {
    }

    public User(Set<Role> userRoles) { this.userRoles = userRoles;
    }

    public User(String userName, int userAge, Set<Role> userRoles) {
        this.userName = userName;
        this.userAge = userAge;
        this.userRoles = userRoles;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public Set<Role> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<Role> userRoles) {
        this.userRoles = userRoles;
    }
}