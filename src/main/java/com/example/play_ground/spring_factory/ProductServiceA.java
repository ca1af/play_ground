package com.example.play_ground.spring_factory;

import com.example.play_ground.spring_factory.provider.ProductProvider;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceA implements ProductService {
    @Override
    public void use() {
        System.out.println("use A");
    }

    @Override
    public ProductProvider getProvider() {
        return ProductProvider.ProductA;
    }
}
