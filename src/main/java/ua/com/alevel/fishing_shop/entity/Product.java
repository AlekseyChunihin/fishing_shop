package ua.com.alevel.fishing_shop.entity;


import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(name = "short_description")
    private String description;

    @Column(name = "amount_in_package", nullable = false)
    private Integer amountInPackage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    @Access(AccessType.PROPERTY)
    private Brand brand;

    @Column(name = "product_quantity", nullable = false)
    private Integer productQuantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    CartProducts cartProducts;

    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    public Product() {
    }

    public CartProducts getCartProducts() {
        return cartProducts;
    }

    public void setCartProducts(CartProducts cartProducts) {
        this.cartProducts = cartProducts;
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

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
