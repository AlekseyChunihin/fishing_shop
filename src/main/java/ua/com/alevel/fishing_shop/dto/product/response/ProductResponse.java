package ua.com.alevel.fishing_shop.dto.product.response;

import ua.com.alevel.fishing_shop.dto.cartproducts.response.CartWithoutProductsResponse;
import ua.com.alevel.fishing_shop.entity.Product;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;

public class ProductResponse {

    private Integer id;
    private String name;
    private BigDecimal price;
    private String description;
    private Integer amountInPackage;
    private String brand;
    private Integer productQuantity;
    private OffsetDateTime createdAt;
    private CartWithoutProductsResponse cartWithoutProductsResponse;

    public ProductResponse() {
    }

    public static ProductResponse from(Product product) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setName(product.getName());
        productResponse.setPrice(product.getPrice());
        productResponse.setAmountInPackage(product.getAmountInPackage());
        productResponse.setBrand(product.getBrand().getName());
        productResponse.setProductQuantity(product.getProductQuantity());
        productResponse.setDescription(product.getDescription());
        productResponse.setCreatedAt(product.getCreatedAt());
        if(Objects.nonNull(productResponse.getCartWithoutProductsResponse())){//TODO null where the href
            productResponse.setCartWithoutProductsResponse(CartWithoutProductsResponse.from(product.getCartProducts()));
        }
        return productResponse;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAmountInPackage() {
        return amountInPackage;
    }

    public void setAmountInPackage(Integer amountInPackage) {
        this.amountInPackage = amountInPackage;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public CartWithoutProductsResponse getCartWithoutProductsResponse() {
        return cartWithoutProductsResponse;
    }

    public void setCartWithoutProductsResponse(CartWithoutProductsResponse cartWithoutProductsResponse) {
        this.cartWithoutProductsResponse = cartWithoutProductsResponse;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
