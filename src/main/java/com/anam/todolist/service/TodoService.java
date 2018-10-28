package com.anam.todolist.service;

import com.anam.todolist.model.Task;

import java.util.List;

public interface TodoService {
    int save(Task task);
    Task get(int id);
    List<Task> list();
    void update(int id, Task task);
    void delete(int id);
}
