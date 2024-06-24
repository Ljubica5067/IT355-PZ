package org.example.it355pz.service;


import org.example.it355pz.dao.RoleDao;
import org.example.it355pz.dao.UserDao;
import org.example.it355pz.entity.Role;
import org.example.it355pz.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void initRoleAndUser() {

        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("For admin role");
        roleDao.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("For user role");
        roleDao.save(userRole);

        User adminUser = new User();
        adminUser.setUserName("Admin");
        adminUser.setUserPassword(getEncodedPassword("admin"));
        adminUser.setUserFirstName("Admin");
        adminUser.setUserLastName("Admin");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userDao.save(adminUser);

        User user = new User();
        user.setUserName("LjubicaD");
        user.setUserPassword(getEncodedPassword("ljubica"));
        user.setUserFirstName("Ljubica");
        user.setUserLastName("Djukic");
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);
        user.setRole(userRoles);
        userDao.save(user);
    }

        public User registerNewUser(User user) {
            Role role = roleDao.findById("User").get();
            Set<Role> userRoles = new HashSet<>();
            userRoles.add(role);
            user.setRole(userRoles);
            user.setUserPassword(getEncodedPassword(user.getUserPassword()));

            return userDao.save(user);
        }

        public String getEncodedPassword(String password) {
            return passwordEncoder.encode(password);
        }
    }
