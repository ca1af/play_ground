package com.example.play_ground.woo_wa;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class BiggerMemoryTest {
    // 더 큰 객체로 테스트
    private static class StaticClass {
        private static String[] COMPANY_NAMES = new String[100];
        private static int[] VALUES = new int[100];
        private static double[] METRICS = new double[100];

        static {
            // 초기화
            for (int i = 0; i < 100; i++) {
                COMPANY_NAMES[i] = "Company" + i;
                VALUES[i] = i;
                METRICS[i] = i * 1.5;
            }
        }
    }

    private static class NonStaticClass {
        private String[] companyNames = new String[100];
        private int[] values = new int[100];
        private double[] metrics = new double[100];

        public NonStaticClass() {
            // 초기화
            for (int i = 0; i < 100; i++) {
                companyNames[i] = "Company" + i;
                values[i] = i;
                metrics[i] = i * 1.5;
            }
        }
    }

    private static final int ITERATIONS = 100_000; // 객체가 커져서 반복 횟수 감소
    private static final int WARMUP_ITERATIONS = 5;
    private static final int GC_SLEEP_TIME = 100;

    private long measureMemoryUsage(Runnable action) throws InterruptedException {
        List<Long> measurements = new ArrayList<>();

        for (int i = 0; i < WARMUP_ITERATIONS; i++) {
            action.run();
            System.gc();
            Thread.sleep(GC_SLEEP_TIME);
        }

        for (int i = 0; i < 5; i++) {
            Runtime runtime = Runtime.getRuntime();
            List<Object> instances = new ArrayList<>();

            System.gc();
            Thread.sleep(GC_SLEEP_TIME);

            long before = runtime.totalMemory() - runtime.freeMemory();
            action.run();
            long after = runtime.totalMemory() - runtime.freeMemory();

            measurements.add(after - before);

            instances = null;
            System.gc();
            Thread.sleep(GC_SLEEP_TIME);
        }

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
        System.out.println("Memory Difference: " + (nonStaticMemoryUsage - staticMemoryUsage) / 1024 + "KB");
        System.out.println("Memory Saved: " +
                String.format("%.2f%%",
                        ((nonStaticMemoryUsage - staticMemoryUsage) / (double)nonStaticMemoryUsage) * 100));
    }
}
