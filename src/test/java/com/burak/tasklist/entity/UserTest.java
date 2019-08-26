package com.burak.tasklist.entity;

import org.junit.Before;
import org.junit.Test;

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
    }

    @Test
    public void setTasks() {
    }
}