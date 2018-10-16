package com.example.taskmanager.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "task_id", nullable = false)
    private Integer task_id;

    @Column (name = "name", nullable = false)
    private String name;

    @ManyToOne (cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn (name = "project_id", nullable = false)
    private Project project;

    @ManyToMany (cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinTable (
            name = "users_tasks",
            joinColumns = @JoinColumn (name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users;

    public Integer getTask_id() {
        return task_id;
    }

    public void setTask_id(Integer task_id) {
        this.task_id = task_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
