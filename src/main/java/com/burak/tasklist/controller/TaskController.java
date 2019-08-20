package com.burak.tasklist.controller;


import com.burak.tasklist.entity.Task;
import com.burak.tasklist.entity.User;
import com.burak.tasklist.service.TaskService;
import com.burak.tasklist.service.UserService;
import org.hibernate.annotations.ParamDef;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@CrossOrigin(origins = "*")
@Transactional
@RestController
public class TaskController {

    private final TaskService taskService;
    private final UserService userService;

    public TaskController(TaskService taskService,UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    @PostMapping("/tasks")
    public Task saveTask(@RequestBody Task task, @RequestParam String name){
        task.setUser(userService.findByUsername(name));
        return taskService.save(task);
    }

}
