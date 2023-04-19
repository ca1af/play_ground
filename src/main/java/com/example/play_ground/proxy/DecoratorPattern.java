package com.example.play_ground.proxy;

public class DecoratorPattern {
    static void noDecoratorPattern(){
        TargetInterface targetInterface = new TargetImpl();
        Client client = new Client(targetInterface);
        client.execute();
    }

    static void decoratorPattern(){
        TargetInterface target = new TargetImpl();
        TargetInterface proxy = new Proxy(target);
        Client client = new Client(proxy);
        client.execute();
    }

    public static void main(String[] args) {
        noDecoratorPattern();
        System.out.println("=========================");
        decoratorPattern();
    }
}
