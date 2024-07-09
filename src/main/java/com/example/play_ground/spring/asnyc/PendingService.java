package com.example.play_ground.spring.asnyc;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.retry.annotation.CircuitBreaker;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
@Log4j2
public class PendingService {

    private final ApplicationEventPublisher eventPublisher;

    @Async
    public void pendingRequest(Long savedId) {
        try {
            Thread.sleep(5000); // 5초 pending
            log.info("pended");

        } catch (InterruptedException e){
            throw new IllegalArgumentException("Interrupted");
        }
    }
}
