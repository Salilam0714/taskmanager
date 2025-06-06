package com.taskmanagerproject.taskmanager.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.taskmanagerproject.taskmanager.model.*;

public interface TaskRepository extends JpaRepository<Task, Long>{
     List<Task> findByCompleted(boolean completed);
     List<Task> findByTitleContainingIgnoreCase(String keyword);
     //Containing: LIKE %keyword%
     //IgnoreCase：ignore upper or lower case

}
