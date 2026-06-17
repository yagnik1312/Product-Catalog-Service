package com.example.sprintbootapp.service;

import com.example.sprintbootapp.model.Product;
import com.example.sprintbootapp.repository.ProductRepository;
import com.example.sprintbootapp.repository.ReviewRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository repository;

    @Mock
    private ReviewRepository reviewRepository;

    @InjectMocks
    private ProductService service;

    // ✅ Test getAllProducts()
    @Test
    void testGetAllProducts() {
        int pageNumber = 0;
        int pageSize = 2;

        Product product1 = new Product();
        product1.setId(1L);
        product1.setName("Product 1");

        Product product2 = new Product();
        product2.setId(2L);
        product2.setName("Product 2");

        Page<Product> mockPage = new PageImpl<>(
                java.util.List.of(product1, product2),
                PageRequest.of(pageNumber, pageSize),
                2
        );

        when(repository.findAll(PageRequest.of(pageNumber, pageSize)))
                .thenReturn(mockPage);

        Page<Product> result = service.getAllProducts(pageNumber, pageSize);

        assertEquals(2, result.getContent().size());
        assertEquals("Product 1", result.getContent().get(0).getName());

        // ✅ Verify repository call
        verify(repository, times(1))
                .findAll(PageRequest.of(pageNumber, pageSize));
    }

    // ✅ Test getProductById() - Success case
    @Test
    void testGetProductById_Found() {
        Product product = new Product();
        product.setId(1L);
        product.setName("Test Product");

        when(repository.findById(1L)).thenReturn(Optional.of(product));

        Product result = service.getProductById(1L);

        assertNotNull(result);
        assertEquals("Test Product", result.getName());

        verify(repository, times(1)).findById(1L);
    }

    // ❌ Test getProductById() - Not found case
    @Test
    void testGetProductById_NotFound() {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            service.getProductById(1L);
        });

        assertEquals("Product not found", exception.getMessage());

        verify(repository, times(1)).findById(1L);
    }
}