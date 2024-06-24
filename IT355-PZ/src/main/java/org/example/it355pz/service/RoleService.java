package org.example.it355pz.service;

import org.example.it355pz.dao.RoleDao;
import org.example.it355pz.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    public Role createNewRole (Role role) {
        return roleDao.save(role);
    }
}

