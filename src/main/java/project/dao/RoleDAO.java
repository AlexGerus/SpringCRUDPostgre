package project.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.modules.Role;
import project.modules.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class RoleDAO {

    @PersistenceContext
    private EntityManager em;

    public RoleDAO() {
    }

    @Transactional
    public void addRole(User user, Role role) {
        role.setUser(user);
        em.persist(role);
    }

    @Transactional
    public List<String> getRoles(String login) {
        return em.createQuery("select role.roleName from Role role").getResultList();
    }

    @Transactional
    public Role findRole(long id) {
        return (Role) em.createQuery("select role from Role role where role.idUser =:idUser").setParameter("idUser", id).getSingleResult();
    }

    @Transactional
    public void deleteRole(long id) {
        Role role = findRole(id);
        em.remove(role);
    }
}