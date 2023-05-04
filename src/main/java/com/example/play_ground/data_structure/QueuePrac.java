package com.example.play_ground.data_structure;

public class QueuePrac {
    private class Queue {

        private int[] array;
        private int front;
        private int rear;
        private int maxSize;

        public Queue(int size) {
            array = new int[size];
            front = 0;
            rear = -1;
            maxSize = 0;
        }

        public boolean isEmpty() {
            return (maxSize == 0);
        }

        public boolean isFull() {
            return (maxSize == array.length);
        }

        public void enqueue(int item) {
            if (isFull()) {
                throw new IllegalArgumentException("Queue is full.");
            }
            rear = (rear + 1) % array.length;
            array[rear] = item;
            maxSize++;
        }

        public int dequeue() {
            if (isEmpty()) {
                throw new IllegalArgumentException("Queue is empty.");
            }
            int item = array[front];
            front = (front + 1) % array.length;
            maxSize--;
            return item;
        }

        public void peek() {
            if (isEmpty()) {
                throw new IllegalArgumentException("Queue is empty.");
            }
            System.out.println(array[front] + " Peek!");
        }
    }
}

