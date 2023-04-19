package com.example.play_ground.proxy;

public class Client {
    private TargetInterface targetInterface;
    public Client(TargetInterface targetInterface) {
        this.targetInterface = targetInterface;
    }
    public void execute(){
        targetInterface.run();
    }
}

