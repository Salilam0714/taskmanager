package com.taskmanagerproject.taskmanager.service;
import com.taskmanagerproject.taskmanager.model.Task;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.taskmanagerproject.taskmanager.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getTasks(Boolean completed) {
        if (completed != null) {
            return taskRepository.findByCompleted(completed);
        }
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
    }           //use the optional method .orElseThrow() to handle exception
                //supplier

    @Override
    public List<Task> getTasksByTitle(String keyword) {
        return taskRepository.findByTitleContainingIgnoreCase(keyword);
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Long id, Task taskDetails) {
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

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

}
