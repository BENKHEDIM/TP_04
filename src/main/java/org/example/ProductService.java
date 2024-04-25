package org.example;

public class ProductService {
    private ProductApiClient productApiClient;

    public ProductService(ProductApiClient productApiClient) {
        this.productApiClient = productApiClient;
    }

    public String getProduct(String productId) {
        return productApiClient.getProduct(productId);
    }
}