import org.example.InMemoryProductRepository;
import org.example.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class InMemoryProductRepositoryTest {
    private InMemoryProductRepository repository;

    @BeforeEach
    public void setUp() {
        repository = new InMemoryProductRepository();
    }

    @Test
    public void testAddAndFindById() {
        Product product = new Product(1, "Test Product", 10.0);
        repository.add(product);

        Product result = repository.findById(1);
        assertEquals(product, result);
    }

    @Test
    public void testFindAll() {
        Product product1 = new Product(1, "Product 1", 10.0);
        Product product2 = new Product(2, "Product 2", 20.0);
        repository.add(product1);
        repository.add(product2);

        List<Product> result = repository.findAll();
        assertEquals(2, result.size());
        assertEquals(product1, result.get(0));
        assertEquals(product2, result.get(1));
    }

    @Test
    public void testUpdate() {
        Product product = new Product(1, "Test Product", 10.0);
        repository.add(product);

        Product updatedProduct = new Product(1, "Updated Product", 15.0);
        repository.update(updatedProduct);

        Product result = repository.findById(1);
        assertEquals(updatedProduct, result);
    }

    @Test
    public void testDelete() {
        Product product = new Product(1, "Test Product", 10.0);
        repository.add(product);

        repository.delete(1);
        Product result = repository.findById(1);
        assertNull(result);
    }
}
