package com.example.microservices.dao.impl;

import com.example.microservices.dao.UserDao;
import com.example.microservices.dao.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoImplTest {

    private JdbcTemplate jdbcTemplate;
    private UserDao userDao;

    private User goodUser;

    @Before
    public void setup() {
        jdbcTemplate = mock(JdbcTemplate.class);
        userDao = new UserDaoImpl(jdbcTemplate);

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
        when(jdbcTemplate.query(anyString(), any(RowMapper.class))).thenReturn(Arrays.asList(goodUser));

        List<User> users = userDao.findAll();

        assertThat(users, notNullValue());
        assertThat(users.size(), is(1));
    }
}