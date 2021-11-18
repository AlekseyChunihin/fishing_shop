package ua.com.alevel.fishing_shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ua.com.alevel.fishing_shop.entity.Product;
import ua.com.alevel.fishing_shop.repository.ProductRepository;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @PostMapping
    public ResponseEntity addProduct(@RequestBody Product product) {
        try {
            productRepository.save(product);
            return ResponseEntity.badRequest().body("Product save successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
