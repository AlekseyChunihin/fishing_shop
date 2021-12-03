package ua.com.alevel.fishing_shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.fishing_shop.Routes;
import ua.com.alevel.fishing_shop.dto.cartproducts.request.SaveCartProductsRequest;
import ua.com.alevel.fishing_shop.dto.cartproducts.response.CartProductsResponse;
import ua.com.alevel.fishing_shop.service.CartProductsService;

import java.util.List;

@RestController
@RequestMapping(Routes.SHOPPING_CART)
public class CartProductsController {

    private final CartProductsService cartProductsService;

    @Autowired
    public CartProductsController(CartProductsService cartProductsService) {
        this.cartProductsService = cartProductsService;
    }

    @PostMapping
    public ResponseEntity<CartProductsResponse> createCart(@RequestBody SaveCartProductsRequest saveCartProductsRequest) {
        return new ResponseEntity<>(cartProductsService.createCartProducts(saveCartProductsRequest), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CartProductsResponse>> findAllCartProducts() {
        return new ResponseEntity<>(cartProductsService.findAllCarts(), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<CartProductsResponse> findCartProductsById(@PathVariable final Integer id) {
        return new ResponseEntity<>(cartProductsService.findCartProductsByIdForResponse(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<CartProductsResponse> deleteCartProducts(@PathVariable final Integer id) {
        return new ResponseEntity<>(cartProductsService.deleteCartProducts(id), HttpStatus.OK);
    }

    @PostMapping(value = "{cartId}/products/{productId}/add")
    public ResponseEntity<CartProductsResponse> addProductToCartProducts(@PathVariable final Integer cartId,
                                                                         @PathVariable final Integer productId) {
        return new ResponseEntity<>(cartProductsService.addProductToCartProducts(cartId, productId), HttpStatus.OK);
    }

    @PostMapping(value = "{cartId}/products/{productId}/remove")
    public ResponseEntity<CartProductsResponse> removeProductFromCartProducts(@PathVariable final Integer cartId,
                                                                         @PathVariable final Integer productId) {
        return new ResponseEntity<>(cartProductsService.removeProductFromCartProducts(cartId, productId), HttpStatus.OK);
    }
}
