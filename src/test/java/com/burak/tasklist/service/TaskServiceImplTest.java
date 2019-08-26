package com.burak.tasklist.service;

import com.burak.tasklist.entity.Task;
import com.burak.tasklist.repository.TaskRepository;
import com.burak.tasklist.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class TaskServiceImplTest {

    TaskServiceImpl taskService;


    @Mock
    TaskRepository taskRepository;
    @Mock
    UserRepository userRepository;

    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);

        taskService = new TaskServiceImpl(taskRepository,userRepository);
    }

    @Test
    public void getAllTasks() {
        Task task1 = new Task("Koş",null);
        Task task2 = new Task("Yürü",null);
        List<Task> tasks = new ArrayList<>();
        tasks.add(task1);
        tasks.add(task2);

        when(taskRepository.findAll()).thenReturn(tasks);

        List<Task> myTasks = taskService.getAllTasks();

        assertEquals(tasks,myTasks);

    }

    @Test
    public void getTask() {

//        Task task1 = new Task("Koş",null);
//        task1.setId(1L);
//        Task task2 = new Task("Yürü",null);
//        task2.setId(2L);
//        List<Task> tasks = new ArrayList<>();
//        tasks.add(task1);
//        tasks.add(task2);
//
//        when(taskRepository.findById(1L).orElse(null)).thenReturn(task1);
//        when(taskRepository.findById(2L).orElse(null)).thenReturn(task2);
//
//        Task myTask = taskService.getTask(1L);
//        Task nullTask = taskService.getTask(3L);
//
//        assertEquals(task1,myTask);
//        assertEquals(null,nullTask);

    }

    @Test
    public void save() {

        Task task1 = new Task("Koş",null);

        when(taskService.save(task1)).thenReturn(task1);

        Task myTask = taskService.save(task1);

        assertEquals(task1,myTask);

    }

    @Test
    public void delete() {
    }
}