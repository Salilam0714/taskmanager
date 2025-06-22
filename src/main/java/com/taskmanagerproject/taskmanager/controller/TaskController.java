package com.taskmanagerproject.taskmanager.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.taskmanagerproject.taskmanager.service.TaskService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import com.taskmanagerproject.taskmanager.model.Task;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getTasks(@RequestParam(required = false) Boolean completed) {
        return taskService.getTasks(completed);
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }
    @GetMapping("/search")
    public List<Task> getTasksByTitle(@RequestParam String keyword) {
        return taskService.getTasksByTitle(keyword);
    }

    @GetMapping("/sorted")
    public List<Task> getTasksSortedByCreatedAt(@RequestParam(defaultValue = "asc") String order) {
        return taskService.getTasksSortedByCreatedAt(order);
    }
    
    
    @PostMapping //add new tasks
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @PutMapping("/{id}") //renew tasks
    public Task updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
       return taskService.updateTask(id, taskDetails);
    }

    @PutMapping("/{id}/toggle")
    public ResponseEntity<Task> toggleTaskCompleted(@PathVariable Long id) {
        Task updatedTask = taskService.toggleTaskCompleted(id);
        return ResponseEntity.ok(updatedTask); // return 200 OK with Task object
    }

    @DeleteMapping("/{id}")//delete task by id
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }

}
