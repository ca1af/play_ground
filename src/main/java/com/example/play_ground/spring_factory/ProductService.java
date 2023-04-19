package com.example.play_ground.spring_factory;

import com.example.play_ground.spring_factory.provider.ProductProvider;

public interface ProductService {
    void use();
    ProductProvider getProvider();
}
