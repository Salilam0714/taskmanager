package com.taskmanagerproject.taskmanager.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id //this is primary key
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private boolean completed;
    @CreationTimestamp
    private LocalDateTime createdAt;

}
