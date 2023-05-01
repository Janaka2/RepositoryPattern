package org.example;

import java.util.List;

public interface ProductRepository {
    Product findById(long id);
    List<Product> findAll();
    void add(Product product);
    void update(Product product);
    void delete(long id);
}
