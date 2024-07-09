package com.example.play_ground.spring.asnyc;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;


    @Transactional // not needed
    public Long save(){
        Task task = new Task(TaskStatus.PROCESSING);
        taskRepository.save(task);
        return task.getId();
    }

    public TaskStatus getStatus(Long id){
        Task task = taskRepository.findById(id).orElseThrow();
        return task.getTaskStatus();
    }

    @EventListener
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateData(SomeEvent someEvent){
        if (Objects.isNull(someEvent) || someEvent.fooData().isEmpty()){
            Task task = taskRepository.findById(someEvent.id()).orElseThrow();
            task.setFail();
            return;
        }

        Task task = taskRepository.findById(someEvent.id()).orElseThrow();
        task.updateData(someEvent.fooData());
        task.setSuccess();
    }


}
