package com.example.userservice.service.impl;

import com.example.userservice.dao.UserDao;
import com.example.userservice.entity.User;
import com.example.userservice.service.UserService;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceImplTest {

    private UserDao userDao;
    private UserService userService;

    private User goodUser;

    @Before
    public void setup(){
        userDao = mock(UserDao.class);
        userService = new UserServiceImpl(userDao);

        goodUser = new User(
                1L,
                "isc.juancarlosmolina@gmail.com",
                "12345",
                "Juan Carlos",
                "Molina",
                Boolean.TRUE
        );
    }

    @Test
    public void findAll() {
        when(userDao.findAll()).thenReturn(Arrays.asList(goodUser));

        List<User> users = userService.findAll();

        assertThat(users, notNullValue());
        assertThat(users.size(), is(1));
    }

    @Test
    public void save() {
    }

    @Test
    public void findById() {
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void restore() {
    }
}