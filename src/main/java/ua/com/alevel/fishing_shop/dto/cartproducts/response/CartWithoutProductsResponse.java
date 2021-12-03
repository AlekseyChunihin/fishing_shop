package ua.com.alevel.fishing_shop.dto.cartproducts.response;

import ua.com.alevel.fishing_shop.entity.CartProducts;

import java.time.OffsetDateTime;

public class CartWithoutProductsResponse {

    private Integer id;
    private String userName;
    private OffsetDateTime createdAt;


    public CartWithoutProductsResponse() {
    }

    public static CartWithoutProductsResponse from(CartProducts cartProducts) {
        CartWithoutProductsResponse cartWithoutProductsResponse = new CartWithoutProductsResponse();
        cartWithoutProductsResponse.setId(cartProducts.getId());
        cartWithoutProductsResponse.setUserName(cartProducts.getUser().getName());
        cartWithoutProductsResponse.setCreatedAt(cartProducts.getCreatedAt());
        return cartWithoutProductsResponse;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
