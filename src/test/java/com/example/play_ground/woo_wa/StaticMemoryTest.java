package com.example.play_ground.woo_wa;

import com.example.play_ground.woo_wa.cases.NonStaticClass;
import com.example.play_ground.woo_wa.cases.StaticClass;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class StaticMemoryTest {

    private static final int TRIAL_COUNT = 1_000_000;

    @Test
    void static_키워드_사용() {
        long memoryUsage = getMemoryUsage(StaticClass.class);
        System.out.println("static 사용: " + memoryUsage / 1024 + "KB");
    }

    @Test
    void static_키워드_미사용() {
        long memoryUsage = getMemoryUsage(NonStaticClass.class);
        System.out.println("static 미사용: " + memoryUsage / 1024 + "KB");
    }

    // 메모리 사용량을 측정한다.
    private <T> long getMemoryUsage(Class<T> clazz) {
        Runtime runtime = Runtime.getRuntime();
        List<T> instances = new ArrayList<>();

        // 이전 메모리
        long beforeMemory = runtime.totalMemory() - runtime.freeMemory();

        try {
            for (int i = 0; i < TRIAL_COUNT; i++) {
                instances.add(clazz.getDeclaredConstructor().newInstance());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 인스턴스 생성 후 메모리
        long afterMemory = runtime.totalMemory() - runtime.freeMemory();

        return afterMemory - beforeMemory;
    }
}