package com.anam.todolist.service;

import com.anam.todolist.dao.TaskDao;
import com.anam.todolist.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TodoServiceImpl implements TodoService {

    private TaskDao taskDao;

    @Autowired
    public TodoServiceImpl(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @Override
    public int save(Task task) {
        return taskDao.save(task);
    }

    @Override
    public Task get(int id) {
        return taskDao.get(id);
    }

    @Override
    public List<Task> list() {
        return taskDao.list();
    }

    @Override
    public void update(int id, Task task) {
        taskDao.update(id, task);
    }

    @Override
    public void delete(int id) {
        taskDao.delete(id);
    }

}