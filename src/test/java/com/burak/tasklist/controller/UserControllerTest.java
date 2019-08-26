package com.burak.tasklist.controller;

import com.burak.tasklist.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.burak.tasklist.entity.User;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class UserControllerTest {

    UserController userController;

    @Mock
    UserService userService;

    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);

        userController = new UserController(userService);
    }

    @Test
    public void userLogin() {

        User user = new User("burak","b",0,null);
        user.setId(1L);

        when(userService.findByUsername("burak")).thenReturn(user);

        User realUser = userController.userLogin("burak","b");
        User notUser = userController.userLogin("lol","a");
        User wrongPasswordUser = userController.userLogin("burak","yanlış");

        assertEquals(user,realUser);
        assertEquals(null,notUser);
        assertEquals(null,wrongPasswordUser);

    }

    @Test
    public void getCompletedTaskCount() {

        User user = new User("burak","b",10,null);
        user.setId(1L);

        when(userService.findByUsername("burak")).thenReturn(user);

        int CTC = userController.getCompletedTaskCount("burak");

        assertEquals(10,CTC);
        verify(userService,times(1));
    }

    @Test
    public void getAllCompletedTaskCount() {

        User user1 = new User("burak","b",10,null);
        User user2 = new User("bigi","b",15,null);
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);

        when(userService.findAll()).thenReturn(users);

        List returnedUsers = userController.getAllCompletedTaskCount();

        assertEquals(users,returnedUsers);
    }

    @Test
    public void saveUser() {
        User user1 = new User("burak","b",10,null);
        List<User> users = new ArrayList<>();
        users.add(user1);

    }

    @Test
    public void deleteUser() {
    }
}