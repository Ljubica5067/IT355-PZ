package org.example.it355pz.services;



import org.example.it355pz.dao.RoleDao;
import org.example.it355pz.entity.Role;
import org.example.it355pz.service.RoleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RoleServiceTest {

    @Mock
    private RoleDao roleDao;

    @InjectMocks
    private RoleService roleService;

    private Role role;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        role = new Role();
        role.setRoleName("USER");
        role.setRoleDescription("User role");
    }

    @Test
    void createNewRole() {
        when(roleDao.save(any(Role.class))).thenReturn(role);
        Role savedRole = roleService.createNewRole(role);
        assertNotNull(savedRole);
        assertEquals(role.getRoleName(), savedRole.getRoleName());
        verify(roleDao, times(1)).save(role);
    }
}
