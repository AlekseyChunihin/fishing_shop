package ua.com.alevel.fishing_shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alevel.fishing_shop.dto.product.request.SaveProductRequest;
import ua.com.alevel.fishing_shop.dto.product.request.UpdateProductRequest;
import ua.com.alevel.fishing_shop.dto.product.response.ProductResponse;
import ua.com.alevel.fishing_shop.entity.Brand;
import ua.com.alevel.fishing_shop.entity.Product;
import ua.com.alevel.fishing_shop.exception.ProductNotFoundException;
import ua.com.alevel.fishing_shop.repository.ProductRepository;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final BrandService brandService;

    @Autowired
    public ProductService(ProductRepository productRepository, BrandService brandService) {
        this.productRepository = productRepository;
        this.brandService = brandService;
    }

    @Transactional
    public ProductResponse createProduct(SaveProductRequest productRequest) {
        Product product = convertSaveProductRequestToProduct(productRequest);
        return ProductResponse.from(productRepository.save(product));
    }

    @Transactional
    public Product findProductById(Integer id) {
        return productRepository.findById(id).orElseThrow(()
                -> new ProductNotFoundException(id));
    }

    @Transactional
    public ProductResponse findProductByIdForResponse(Integer id) {
        Product product = productRepository.findById(id).orElseThrow(()
                -> new ProductNotFoundException(id));
        return ProductResponse.from(product);
    }

    @Transactional
    public List<ProductResponse> findAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductResponse> productResponses = new ArrayList<>();
        for (Product product1 : products) {
            productResponses.add(ProductResponse.from(product1));
        }
        return productResponses;
    }

    @Transactional
    public ProductResponse deleteProduct(Integer id) {
        Product product = findProductById(id);
        productRepository.delete(product);
        return ProductResponse.from(product);
    }

    @Transactional
    public ProductResponse updateProduct(Integer id, UpdateProductRequest productRequest) {
        Product product = convertUpdateProductRequestToProduct(productRequest);
        Product productForUpdate = findProductById(id);
        productForUpdate.setName(product.getName());
        productForUpdate.setPrice(product.getPrice());
        productForUpdate.setBrand(product.getBrand());
        productForUpdate.setDescription(product.getDescription());
        productForUpdate.setAmountInPackage(product.getAmountInPackage());
        return ProductResponse.from(productForUpdate);
    }

    @Transactional
    private Product convertUpdateProductRequestToProduct(UpdateProductRequest productRequest) {
        Brand brand = brandService.findBrandByName(productRequest.getBrand());
        Product product = new Product();
        product.setId(productRequest.getId());
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setDescription(productRequest.getDescription());
        product.setAmountInPackage(productRequest.getAmountInPackage());
        product.setBrand(brand);
        product.setProductQuantity(productRequest.getProductQuantity());
        product.setCreatedAt(OffsetDateTime.now());
        return product;
    }

    @Transactional
    public Product convertSaveProductRequestToProduct(SaveProductRequest productRequest) {
        Brand brand = brandService.findBrandByName(productRequest.getBrand());
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setDescription(productRequest.getDescription());
        product.setAmountInPackage(productRequest.getAmountInPackage());
        product.setBrand(brand);
        product.setProductQuantity(productRequest.getProductQuantity());
        product.setCreatedAt(OffsetDateTime.now());
        return product;
    }
}

