package com.example.play_ground.spring_factory;

import com.example.play_ground.spring_factory.provider.ProductProvider;
import com.example.play_ground.spring_factory.provider.ProductProviderFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class ClientTest {

    @InjectMocks
    private Client client;

    @Mock
    private ProductProviderFactory productProviderFactory;

    @Mock
    private ProductService productService;

    @BeforeEach
    public void setUp() {
        // ProductService의 Mock 객체에 대한 동작 정의
        Mockito.doAnswer(invocation -> {
            System.out.println("use() 메서드가 호출되었습니다. " + ((ProductService)invocation.getMock()).getProvider() + "는 ");
            return null;
        }).when(productService).use();
    }

    @Test
    public void testDoService() {
        // ProductProviderFactory의 Mock 객체에 대한 동작 정의
        Mockito.when(productProviderFactory.getService(any(ProductProvider.class))).thenReturn(productService);

        // Client의 doService() 메서드 호출
        client.doService(ProductProvider.ProductA);

        // ProductService의 use() 메서드가 1번 호출되었는지 확인
        Mockito.verify(productService, times(1)).use();
    }
}
