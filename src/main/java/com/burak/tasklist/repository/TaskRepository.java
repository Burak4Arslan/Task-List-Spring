package com.burak.tasklist.repository;

import com.burak.tasklist.entity.Task;
import com.burak.tasklist.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}

