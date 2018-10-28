package com.anam.todolist.controller;

import com.anam.todolist.model.Task;
import com.anam.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tasks")
public class ToDoController {

    private TodoService todoService;

    @Autowired
    public ToDoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("")
    @CrossOrigin
    public ResponseEntity<Task> save(@RequestBody Task task) {
        int id = todoService.save(task);
        return ResponseEntity.ok().body(task);
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<Task> get(@PathVariable("id") int id) {
        Task task = todoService.get(id);
        return ResponseEntity.ok().body(task);
    }

    @GetMapping("")
    @CrossOrigin
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = todoService.list();
        return ResponseEntity.ok().body(tasks);
    }

    @PutMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Task task) {
        todoService.update(id, task);
        return ResponseEntity.ok().body("Task updated successfully");
    }

    @DeleteMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        todoService.delete(id);
        return ResponseEntity.ok().body("Task deleted successfully");
    }

}
