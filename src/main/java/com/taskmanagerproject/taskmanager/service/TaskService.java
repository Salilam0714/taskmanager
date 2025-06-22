package com.taskmanagerproject.taskmanager.service;
import java.util.List;
import com.taskmanagerproject.taskmanager.model.Task;


public interface TaskService {
    List<Task> getTasks(Boolean completed);
    Task getTaskById(Long id);
    List<Task> getTasksByTitle(String keyword);
    List<Task> getTasksSortedByCreatedAt(String order);
    Task createTask(Task task);
    Task updateTask(Long id, Task task);
    Task toggleTaskCompleted(Long id);
    void deleteTask(Long id);
}
