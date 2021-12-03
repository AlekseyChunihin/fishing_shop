package ua.com.alevel.fishing_shop.dto.product.request;

import java.math.BigDecimal;

public class SaveProductRequest {

    private String name;
    private BigDecimal price;
    private String description;
    private Integer amountInPackage;
    private String brand;
    private Integer productQuantity;

    public SaveProductRequest() {
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

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
