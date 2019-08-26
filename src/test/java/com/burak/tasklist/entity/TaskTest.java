package com.burak.tasklist.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TaskTest {

    Task task;
    User user;

    @Before
    public void setUp() throws Exception {
        user = new User();
        task = new Task("Koş",user);
    }

    @Test
    public void getContent() {

        assertEquals("Koş",task.getContent());

    }

    @Test
    public void setContent() {
        task.setContent("Koşma");

        assertEquals("Koşma",task.getContent());

    }

    @Test
    public void getUser() {

        assertEquals(user,task.getUser());

    }

    @Test
    public void setUser() {
        User user2 = new User();
        task.setUser(user2);

        assertEquals(user2,task.getUser());
    }
}