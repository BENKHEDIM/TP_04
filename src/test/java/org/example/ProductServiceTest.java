package org.example;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductApiClient productApiClient;

    @Test
    public void testGetProductSuccess() {
        ProductService productService = new ProductService(productApiClient);
        when(productApiClient.getProduct("123")).thenReturn("Product Details");

        String result = productService.getProduct("123");
        assertEquals("Product Details", result);
        verify(productApiClient).getProduct("123");
    }

    @Test
    public void testGetProductFailure() {
        ProductService productService = new ProductService(productApiClient);
        when(productApiClient.getProduct("123")).thenThrow(new RuntimeException("Failed to fetch data"));

        Exception exception = assertThrows(RuntimeException.class, () -> {
            productService.getProduct("123");
        });

        assertEquals("Failed to fetch data", exception.getMessage());
        verify(productApiClient).getProduct("123");
    }

    @Test
    public void testGetProductDataFormatError() {
        ProductService productService = new ProductService(productApiClient);
        when(productApiClient.getProduct("123")).thenReturn("Invalid Data");

        String result = productService.getProduct("123");
        assertNotEquals("Product Details", result);
        verify(productApiClient).getProduct("123");
    }
}
