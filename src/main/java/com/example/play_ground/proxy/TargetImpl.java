package com.example.play_ground.proxy;

public class TargetImpl implements TargetInterface {
    @Override
    public void run() {
        System.out.println("I'm running");
    }
}
