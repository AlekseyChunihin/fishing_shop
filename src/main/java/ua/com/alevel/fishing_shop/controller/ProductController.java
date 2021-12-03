package ua.com.alevel.fishing_shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.fishing_shop.Routes;
import ua.com.alevel.fishing_shop.dto.product.request.SaveProductRequest;
import ua.com.alevel.fishing_shop.dto.product.request.UpdateProductRequest;
import ua.com.alevel.fishing_shop.dto.product.response.ProductResponse;
import ua.com.alevel.fishing_shop.service.ProductService;

import java.util.List;

@RestController
@RequestMapping(Routes.PRODUCTS)
public class ProductController {


    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody final SaveProductRequest productRequest) {
        return new ResponseEntity<>(productService.createProduct(productRequest), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAllProducts() {
        return new ResponseEntity<>(productService.findAllProducts(), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<ProductResponse> findProductById(@PathVariable final Integer id) {
        return new ResponseEntity<>(productService.findProductByIdForResponse(id), HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable final Integer id, @RequestBody final UpdateProductRequest productRequest) {
        return new ResponseEntity<>(productService.updateProduct(id, productRequest), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<ProductResponse> deleteProduct(@PathVariable final Integer id) {
        return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.OK);
    }
}
