package com.burak.tasklist.controller;

import com.burak.tasklist.entity.Task;
import com.burak.tasklist.service.TaskService;
import com.burak.tasklist.service.TaskServiceImpl;
import com.burak.tasklist.service.UserService;
import com.burak.tasklist.entity.User;
import com.burak.tasklist.service.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class TaskControllerTest {

    @Mock
    TaskServiceImpl taskService;
    @Mock
    UserServiceImpl userService;

    TaskController taskController;
    User user;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        taskController = new TaskController(taskService,userService);
        user = new User("burak","b",10,null);
        user.setId(1L);
    }

    @Test
    public void getMyTasks() {

        Task task1 = new Task("Koş",user);
        Task task2 = new Task("Yürü",user);
        List<Task> tasks = new ArrayList<>();
        tasks.add(task1);
        tasks.add(task2);

        when(taskService.getAllTasks()).thenReturn(tasks);
        when(userService.findByUsername("burak")).thenReturn(user);

        List<Task> myTasks = taskController.getMyTasks(user.getName());


        assertEquals(tasks,myTasks);

    }

    @Test
    public void saveTask() {

        Task task1 = new Task("Koş",null);

        when(taskService.save(task1)).thenReturn(task1);
        when(userService.findByUsername("burak")).thenReturn(user);

        Task myTask = taskController.saveTask(task1,"burak");

        assertEquals(task1,myTask);

    }

    @Test
    public void deleteTask() {
    }

    @Test
    public void deleteCompletedTask() {
    }
}