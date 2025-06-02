package com.taskmanagerproject.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.taskmanagerproject.taskmanager.model.*;

public interface TaskRepository extends JpaRepository<Task, Long>{

}
