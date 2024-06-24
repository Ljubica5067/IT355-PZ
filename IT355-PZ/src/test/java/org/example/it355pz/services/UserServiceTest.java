package org.example.it355pz.services;



import org.example.it355pz.dao.RoleDao;
import org.example.it355pz.dao.UserDao;
import org.example.it355pz.entity.Role;
import org.example.it355pz.entity.User;
import org.example.it355pz.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserDao userDao;

    @Mock
    private RoleDao roleDao;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    private User user;
    private Role userRole;
    private Role adminRole;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        user = new User();
        user.setUserName("LjubicaD");
        user.setUserPassword("ljubica");
        user.setUserFirstName("Ljubica");
        user.setUserLastName("Djukic");

        userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("For user role");

        adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("For admin role");
    }

    @Test
    void initRoleAndUser() {
        when(roleDao.save(any(Role.class))).thenReturn(adminRole).thenReturn(userRole);
        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");

        userService.initRoleAndUser();

        verify(roleDao, times(2)).save(any(Role.class));
        verify(userDao, times(2)).save(any(User.class));
        verify(passwordEncoder, times(2)).encode(anyString());
    }

    @Test
    void registerNewUser() {
        when(roleDao.findById("User")).thenReturn(Optional.of(userRole));
        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");
        when(userDao.save(any(User.class))).thenReturn(user);

        User registeredUser = userService.registerNewUser(user);

        assertNotNull(registeredUser);
        assertEquals("LjubicaD", registeredUser.getUserName());
        assertEquals("encodedPassword", registeredUser.getUserPassword());
        verify(roleDao, times(1)).findById("User");
        verify(passwordEncoder, times(1)).encode(anyString());
        verify(userDao, times(1)).save(user);
    }

    @Test
    void getEncodedPassword() {
        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");

        String encodedPassword = userService.getEncodedPassword("plainPassword");

        assertNotNull(encodedPassword);
        assertEquals("encodedPassword", encodedPassword);
        verify(passwordEncoder, times(1)).encode("plainPassword");
    }
}
