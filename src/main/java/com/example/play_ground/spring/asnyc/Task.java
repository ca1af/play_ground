package com.example.play_ground.spring.asnyc;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TaskStatus taskStatus;

    private String data;

    public Task(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public void updateData(String data){
        this.data = data;
    }

    public void setSuccess(){
        this.taskStatus = TaskStatus.SUCCESS;
    }

    public void setFail(){
        this.taskStatus = TaskStatus.FAIL;
    }
}
