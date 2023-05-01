package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryProductRepository implements ProductRepository {
    private List<Product> products = new ArrayList<>();

    @Override
    public Product findById(long id) {
        Optional<Product> product = products.stream().filter(p -> p.getId() == id).findFirst();
        return product.orElse(null);
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products);
    }

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public void update(Product product) {
        int index = products.indexOf(findById(product.getId()));
        if (index != -1) {
            products.set(index, product);
        }
    }

    @Override
    public void delete(long id) {
        products.removeIf(p -> p.getId() == id);
    }
}
