package com.burak.tasklist.entity;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserTest {

    User user;

    @Before
    public void setUp() throws Exception {
        user = new User("burak","b",0,null);
    }

    @Test
    public void getName() {
        assertEquals("burak",user.getName());
    }

    @Test
    public void setName() {
        user.setName("bigi");
        assertEquals("bigi",user.getName());
    }

    @Test
    public void getPassword() {
        assertEquals("b",user.getPassword());
    }

    @Test
    public void setPassword() {
        user.setPassword("a");
        assertEquals("a",user.getPassword());
    }

    @Test
    public void getCompletedTasks() {
        assertEquals(0,user.getCompletedTasks());
    }

    @Test
    public void setCompletedTasks() {
        user.setCompletedTasks(10);
        assertEquals(10,user.getCompletedTasks());
    }

    @Test
    public void getTasks() {
        Task task = new Task("koş",null);
        List<Task> tasks = new ArrayList<>();
        tasks.add(task);
        User myUser = new User("bi","b",5,tasks);

        assertEquals(tasks,myUser.getTasks());
    }

    @Test
    public void setTasks() {
        Task task = new Task("koş",user);
        List<Task> tasks = new ArrayList<>();
        tasks.add(task);
        User myUser = new User("bi","b",5,null);
        user.setTasks(tasks);

        assertEquals(tasks,user.getTasks());

    }
}