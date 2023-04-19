package com.example.play_ground.java_factory;

public class Client {
    public static void main(String[] args) {
        ProductFactory factory = new ProductFactory();

        Product productA = factory.createProduct("A");
        productA.use();

        Product productB = factory.createProduct("B");
        productB.use();
    }
}