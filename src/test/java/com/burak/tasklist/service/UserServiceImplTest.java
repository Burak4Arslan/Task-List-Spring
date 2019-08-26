package com.burak.tasklist.service;

import com.burak.tasklist.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.burak.tasklist.entity.User;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class UserServiceImplTest {


    UserServiceImpl userService;

    @Mock
    UserRepository userRepository;

    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);

        userService = new UserServiceImpl(userRepository);
    }

    @Test
    public void findByUsername() {

        User user1 = new User("burak","b",0,null);
        User user2 = new User("bigi","b",0,null);
        User user3 = new User("bi","b",0,null);

        List<User> mockUsers = new ArrayList<>();
        mockUsers.add(user1);
        mockUsers.add(user2);
        mockUsers.add(user3);

        when(userRepository.findByName("burak")).thenReturn(user1);
        when(userRepository.findByName("bigi")).thenReturn(user2);
        when(userRepository.findByName("bi")).thenReturn(user3);

        User myUser = userService.findByUsername("bigi");

        assertEquals(user2, myUser);
    }

    @Test
    public void findAll() {
        User user = new User();
        List<User> mockUsers = new ArrayList<>();
        mockUsers.add(user);

        when(userRepository.findAll()).thenReturn(mockUsers);

        List<User> users = userService.findAll();

        assertEquals(users.size(),mockUsers.size());
        verify(userRepository,times(1)).findAll();
    }

    @Test
    public void save() {

        User user = new User("burak","b",5,null);
        List<User> mockUsers = new ArrayList<>();
        mockUsers.add(user);
        User newUser = new User("bigi","b",10,null);

        when(userRepository.save(user)).thenReturn(null);
        when(userRepository.save(newUser)).thenReturn(newUser);

        User myUser = userService.save(newUser);

        assertEquals(newUser,myUser);
        verify(userRepository,times(2));
    }

    @Test
    public void deleteById() {
    }

    @Test
    public void findById() {
    }
}