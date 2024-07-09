package com.example.play_ground.spring.asnyc;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class DataSupplyService {

    private final PendingService pendingService;

    private final TaskService taskService;

    public void getData() {
        log.info("started");

        Long savedId = taskService.save();

        pendingService.pendingRequest(savedId);

        log.info("ended");
    }
}
