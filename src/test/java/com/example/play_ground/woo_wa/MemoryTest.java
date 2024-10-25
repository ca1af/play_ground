package com.example.play_ground.woo_wa;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class MemoryTest {
    private static class StaticClass {
        private static int COMPANY_NAME = Integer.MAX_VALUE;
    }

    private static class NonStaticClass {
        private int COMPANY_NAME = Integer.MAX_VALUE;
    }

    private static final int ITERATIONS = 1_000_000;
    private static final int WARMUP_ITERATIONS = 5;
    private static final int GC_SLEEP_TIME = 100;

    private long measureMemoryUsage(Runnable action) throws InterruptedException {
        // 여러 번 측정하여 평균값 계산
        List<Long> measurements = new ArrayList<>();

        for (int i = 0; i < WARMUP_ITERATIONS; i++) {
            // Warmup phase
            action.run();
            System.gc();
            Thread.sleep(GC_SLEEP_TIME);
        }

        for (int i = 0; i < 5; i++) {
            Runtime runtime = Runtime.getRuntime();
            List<Object> instances = new ArrayList<>();

            // 메모리 초기화
            System.gc();
            Thread.sleep(GC_SLEEP_TIME);

            long before = runtime.totalMemory() - runtime.freeMemory();
            action.run();
            long after = runtime.totalMemory() - runtime.freeMemory();

            measurements.add(after - before);

            // 다음 측정을 위한 정리
            instances = null;
            System.gc();
            Thread.sleep(GC_SLEEP_TIME);
        }

        // 평균값 계산
        return (long) measurements.stream()
                .mapToLong(Long::valueOf)
                .average()
                .orElse(0.0);
    }

    @Test
    void compareMemoryUsage() throws InterruptedException {
        // Static class 측정
        long staticMemoryUsage = measureMemoryUsage(() -> {
            List<Object> instances = new ArrayList<>();
            for (int i = 0; i < ITERATIONS; i++) {
                instances.add(new StaticClass());
            }
        });

        // Non-static class 측정
        long nonStaticMemoryUsage = measureMemoryUsage(() -> {
            List<Object> instances = new ArrayList<>();
            for (int i = 0; i < ITERATIONS; i++) {
                instances.add(new NonStaticClass());
            }
        });

        System.out.println("Average Static Memory Usage: " + staticMemoryUsage / 1024 + "KB");
        System.out.println("Average Non-Static Memory Usage: " + nonStaticMemoryUsage / 1024 + "KB");
    }
}
