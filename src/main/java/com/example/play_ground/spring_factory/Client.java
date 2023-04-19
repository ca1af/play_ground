package com.example.play_ground.spring_factory;

import com.example.play_ground.spring_factory.provider.ProductProvider;
import com.example.play_ground.spring_factory.provider.ProductProviderFactory;
import org.springframework.stereotype.Component;

@Component
public class Client {
    private final ProductProviderFactory productProviderFactory;

    public Client(ProductProviderFactory productProviderFactory) {
        this.productProviderFactory = productProviderFactory;
    }

    public void doService(ProductProvider provider){
        ProductService service = productProviderFactory.getService(provider);

        service.use();
    }
}
