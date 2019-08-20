package com.burak.tasklist.service;

import com.burak.tasklist.entity.Task;
import com.burak.tasklist.entity.User;

import java.util.List;

public interface TaskService {

    List<Task> getAllTasks();
    Task save(Task task);
    void delete(Long id);
}
