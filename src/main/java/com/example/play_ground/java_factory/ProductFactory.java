package com.example.play_ground.java_factory;

public class ProductFactory {
    public Product createProduct(String type) {
        if (type.equals("A")) {
            return new ProductA();
        } else if (type.equals("B")) {
            return new ProductB();
        } else {
            throw new IllegalArgumentException("유효하지 않은 제품 타입입니다.");
        }
    }
}
