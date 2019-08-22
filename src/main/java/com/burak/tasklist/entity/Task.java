package com.burak.tasklist.entity;

import javax.persistence.*;

@Entity
public class Task extends BaseEntity{

    private String content;

    @ManyToOne
    private User user;

    public Task(String content, User user) {
        this.content = content;
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Task() {
    }
}
