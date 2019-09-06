package com.example.microservices.service.impl;

import com.example.microservices.dao.UserDao;
import com.example.microservices.dao.domain.User;
import com.example.microservices.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
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
}