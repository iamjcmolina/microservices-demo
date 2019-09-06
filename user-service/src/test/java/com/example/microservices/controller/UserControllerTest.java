package com.example.microservices.controller;

import com.example.microservices.dao.domain.User;
import com.example.microservices.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    private MockMvc mockMvc;

    private UserService userService;
    private UserController userController;

    private User goodUser;

    @Before
    public void setup(){
        userService = mock(UserService.class);
        userController = new UserController(userService);

        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

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
    public void findAll() throws Exception {
        when(userService.findAll()).thenReturn(Arrays.asList(goodUser));

        mockMvc.perform(get("/users"))
                .andExpect(status().isOk());

        verify(userService, times(1)).findAll();
    }
}