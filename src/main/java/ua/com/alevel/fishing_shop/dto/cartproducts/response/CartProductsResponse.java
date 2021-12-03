package ua.com.alevel.fishing_shop.dto.cartproducts.response;

import ua.com.alevel.fishing_shop.dto.product.response.ProductResponse;
import ua.com.alevel.fishing_shop.entity.CartProducts;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CartProductsResponse {

    private Integer id;
    List<ProductResponse> products = new ArrayList<>();
    private String userName;
    private OffsetDateTime createdAt;

    public CartProductsResponse() {
    }

    public static CartProductsResponse from(CartProducts cartProducts) {
        CartProductsResponse cartProductsResponse = new CartProductsResponse();
        cartProductsResponse.setId(cartProducts.getId());
        cartProductsResponse.setUserName(cartProducts.getUser().getName());
        cartProductsResponse.setProducts(cartProducts.getProducts().stream().map(ProductResponse::from).collect(Collectors.toList()));
        cartProductsResponse.setCreatedAt(cartProducts.getCreatedAt());
        return cartProductsResponse;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<ProductResponse> getProducts() {
        return products;
    }

    public void setProducts(List<ProductResponse> products) {
        this.products = products;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
