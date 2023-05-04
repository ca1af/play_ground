package com.example.play_ground.data_structure;

import org.springframework.web.bind.annotation.PatchMapping;

public class StackPrac {
    private class Stack {
        private int top;
        private int[] stackArr;
        private int maxSize;

        public Stack(int size) {
            this.top = -1 ;
            this.maxSize = size;
            this.stackArr = new int[maxSize];
        }

        private void push(int data){
            if (!isFull()){
                top++;
                stackArr[top] = data;
            } else {
                throw new IllegalArgumentException("full!");
            }
        }

        private int pop(){
            if (!isEmpty()){
                int data = stackArr[top];
                top--;
                return data;
            } else {
                throw new IllegalArgumentException("empty!");
            }
        }

        private void peek(){
            if (!isEmpty()){
                System.out.println(stackArr[top] + "Peek!");
            } else {
                throw new IllegalArgumentException("empty!");
            }
        }

        private boolean isEmpty(){
            return (top == -1);
        }

        private boolean isFull(){
            return (top == maxSize - 1);
        }

    }
}
