package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.dao.RoleDAO;
import project.modules.Role;
import project.modules.User;

@Service
public class RoleService {

    @Autowired
    private RoleDAO roleDAO;

    public RoleService() {
    }

    @Transactional
    public void addRole(User user, Role role) {
        roleDAO.addRole(user,role);
    }

    @Transactional
    public void deleteRole(long roleId) {
        roleDAO.deleteRole(roleId);
    }

    @Transactional
    public Role findRole(long roleId) {
        return roleDAO.findRole(roleId);
    }
}