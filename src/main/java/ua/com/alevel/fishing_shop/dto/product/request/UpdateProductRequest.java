package ua.com.alevel.fishing_shop.dto.product.request;

import java.math.BigDecimal;

public class UpdateProductRequest {

    private Integer id;
    private String name;
    private BigDecimal price;
    private String description;
    private Integer amountInPackage;
    private String brand;
    private Integer productQuantity;

    public UpdateProductRequest() {
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
}
