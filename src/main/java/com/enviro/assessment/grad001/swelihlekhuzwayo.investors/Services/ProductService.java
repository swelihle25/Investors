package com.enviro.assessment.grad001.swelihlekhuzwayo.investors.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enviro.assessment.grad001.swelihlekhuzwayo.investors.Entities.Product;
import com.enviro.assessment.grad001.swelihlekhuzwayo.investors.Repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    /**
     * Constructor-based dependency injection for ProductRepository.
     * Initializes the service and optionally pre-populates some test data.
     *
     * @param productRepository The repository handling Product data operations.
     */
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;

        // Sample data for demonstration purposes
        Product p1 = new Product();
        p1.setProductName("NasDaq");
        p1.setProductType("SAVINGS");
        productRepository.save(p1);

        Product p2 = new Product();
        p2.setProductName("Ripple");
        p2.setProductType("SAVINGS");
        productRepository.save(p2);

        Product p3 = new Product();
        p3.setProductName("Bitcoin");
        p3.setProductType("RETIREMENT");
        productRepository.save(p3);
    }

    /**
     * Retrieves all products from the repository.
     *
     * @return A list of all products.
     */
    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    /**
     * Retrieves a product by its ID.
     *
     * @param id The ID of the product to retrieve.
     * @return An Optional containing the Product if found, otherwise empty.
     */
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    /**
     * Saves a product to the repository.
     *
     * @param product The Product object to be saved.
     * @return The saved Product object.
     */
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    /**
     * Deletes a product by its ID.
     *
     * @param id The ID of the product to delete.
     */
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
