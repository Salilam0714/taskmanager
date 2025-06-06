package com.taskmanagerproject.taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.taskmanagerproject.taskmanager.service.TaskService;
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

    
    @PostMapping //add new tasks
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @PutMapping("/{id}") //renew tasks
    public Task updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
       return taskService.updateTask(id, taskDetails);
    }

    @DeleteMapping("/{id}")//delete task by id
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }

}
