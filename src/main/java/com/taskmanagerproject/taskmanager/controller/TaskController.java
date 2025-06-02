package com.taskmanagerproject.taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.taskmanagerproject.taskmanager.repository.TaskRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import com.taskmanagerproject.taskmanager.model.Task;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Optional;



@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping //get all the tasks
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
                //use the optional method .orElseThrow() to handle exception
                //supplier
    }
    
    
    @PostMapping //add new tasks
    public Task createTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    @PutMapping("/{id}") //renew tasks
    public Task updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
        Optional<Task> optionalTask = taskRepository.findById(id); //optional is a container represent that a value may or may not exist

        if (optionalTask.isPresent()) {  //if the "task" exist
            Task task = optionalTask.get(); //then get the task
            task.setTitle(taskDetails.getTitle()); //set the new title
            task.setDescription(taskDetails.getDescription()); //set the new description
            task.setCompleted(taskDetails.isCompleted()); //set the new state
            return taskRepository.save(task); //then save the update
        } else {
            throw new RuntimeException("Task not found with id " + id); //exception handling!
        }
    }

    @DeleteMapping("/{id}")//delete task by id
    public void deleteTask(@PathVariable Long id){
        taskRepository.deleteById(id);
    }

}
