import org.example.Product;
import org.example.ProductRepository;
import org.example.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProductServiceTest {
    private ProductRepository repository;
    private ProductService productService;

    @BeforeEach
    public void setUp() {
        repository = Mockito.mock(ProductRepository.class);
        productService = new ProductService(repository);
    }

    @Test
    public void testFindProductById() {
        Product product = new Product(1, "Test Product", 10.0);
        when(repository.findById(1)).thenReturn(product);

        Product result = productService.findProductById(1);
        assertEquals(product, result);
    }

    @Test
    public void testFindAllProducts() {
        List<Product> products = Arrays.asList(
                new Product(1, "Product 1", 10.0),
                new Product(2, "Product 2", 20.0)
        );
        when(repository.findAll()).thenReturn(products);

        List<Product> result = productService.findAllProducts();
        assertEquals(products, result);
    }

    @Test
    public void testAddProduct() {
        Product product = new Product(1, "Test Product", 10.0);

        productService.addProduct(product);
        verify(repository, times(1)).add(product);
    }

    @Test
    public void testUpdateProduct() {
        Product product = new Product(1, "Updated Product", 15.0);

        productService.updateProduct(product);
        verify(repository, times(1)).update(product);
    }

    @Test
    public void testDeleteProduct() {
        long id = 1;

        productService.deleteProduct(id);
        verify(repository, times(1)).delete(id);
    }
}
