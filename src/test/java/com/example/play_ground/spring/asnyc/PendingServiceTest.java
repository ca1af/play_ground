package com.example.play_ground.spring.asnyc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PendingServiceTest {
    @Autowired
    private PendingService pendingService;

    @Test
    void name() {
        pendingService.pendingRequest(1L);
    }
}