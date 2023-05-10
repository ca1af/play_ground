package com.example.play_ground.data_structure;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueuePrac {
    public static void main(String[] args) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(10, Collections.reverseOrder());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // 요소 추가
        maxHeap.add(5);
        maxHeap.add(2);
        maxHeap.add(10);
        maxHeap.add(3);

        minHeap.add(5);
        minHeap.add(2);
        minHeap.add(10);
        minHeap.add(3);

        // 요소 삭제
        while (!maxHeap.isEmpty()) {
            int maxHeapElement = maxHeap.poll();
            System.out.println(maxHeapElement + "maxHeap!!");
        }

        while (!minHeap.isEmpty()){
            int minHeapElement = minHeap.poll();
            System.out.println(minHeapElement + "minHeap!!");
        }
    }


}
