package org.example;

import java.util.List;

public class ProductService {
    private ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product findProductById(long id) {
        return repository.findById(id);
    }

    public List<Product> findAllProducts() {
        return repository.findAll();
    }

    public void addProduct(Product product) {
        repository.add(product);
    }

    public void updateProduct(Product product) {
        repository.update(product);
    }

    public void deleteProduct(long id) {
        repository.delete(id);
    }
}