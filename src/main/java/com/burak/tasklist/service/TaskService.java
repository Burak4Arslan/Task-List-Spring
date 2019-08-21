package com.burak.tasklist.service;

import com.burak.tasklist.entity.Task;

import java.util.List;

public interface TaskService {

    List<Task> getAllTasks();
    Task getTask(Long id);
    Task save(Task task);
    void delete(Long id);
}
