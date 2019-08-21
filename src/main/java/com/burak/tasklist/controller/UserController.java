package com.burak.tasklist.controller;

import com.burak.tasklist.entity.User;
import com.burak.tasklist.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@CrossOrigin(origins = "*")
@Transactional
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public User userLogin(@RequestParam String username, @RequestParam String password) {

        User user = userService.findByUsername(username);

        if(user==null) {
            return null;
        }

        if(user.getPassword().equals(password)) {
            return user;
        } else {
            return null;
        }

    }

    @GetMapping("/users/completedTaskCount")
    public int getCompletedTaskCount(@RequestParam String username) {
        return userService.findByUsername(username).getCompletedTasks();
    }

    @PostMapping("/users")
    public User saveUser(@RequestBody final User user) {

        List<User> allUsers = userService.findAll();

        for (User iteUser : allUsers) {
            if(iteUser.getName().equals(user.getName())) {
                return null;
            }
        }
        return userService.save(user);
    }

}
