package com.enviro.assessment.grad001.swelihlekhuzwayo.investors.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enviro.assessment.grad001.swelihlekhuzwayo.investors.Entities.Product;
import com.enviro.assessment.grad001.swelihlekhuzwayo.investors.Repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository _productRepository;

    public ProductService(ProductRepository productRepository){
        this._productRepository = productRepository;

        Product p1 = new Product();
        p1.setProductName("NasDaq");
        p1.setProductType("SAVINGS");

        Product p2 = new Product();
        p2.setProductName("Ripple");
        p2.setProductType("SAVINGS");


        Product p3 = new Product();
        p3.setProductName("Bitcoin");
        p3.setProductType("RETIREMENT");

        productRepository.save(p1);
        productRepository.save(p2);
        productRepository.save(p3);


    }
    // Method to retrieve all products
    public List<Product> getAllProducts() {
        return this._productRepository.findAll();
    }

    // Method to retrieve a product by id
    public Optional<Product> getProductById(Long id) {
        return _productRepository.findById(id);
    }

    // Method to save a product
    public Product saveProduct(Product product) {
        return _productRepository.save(product);
    }

    // Method to delete a product
    public void deleteProduct(Long id) {
        _productRepository.deleteById(id);
    }
}
