package com.burak.tasklist.controller;


import com.burak.tasklist.entity.Task;
import com.burak.tasklist.entity.User;
import com.burak.tasklist.service.TaskService;
import com.burak.tasklist.service.UserService;
import org.hibernate.annotations.ParamDef;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/tasks")
    public List<Task> getMyTasks(@RequestParam String name) {
        List<Task> allTasks = taskService.getAllTasks();
        User user = userService.findByUsername(name);
        Long userID = user.getId();
        List<Task> returningTasks = new ArrayList<Task>();
        for(Task t : allTasks) {
            if(t.getUser().getId() == userID) {
                returningTasks.add(t);
            }
        }
        return returningTasks;
    }

    @PostMapping("/tasks")
    public Task saveTask(@RequestBody Task task, @RequestParam String name){
        task.setUser(userService.findByUsername(name));
        return taskService.save(task);
    }

    @DeleteMapping("tasks")
    public void saveTask(@RequestParam Long id){
        taskService.delete(id);
    }

}
