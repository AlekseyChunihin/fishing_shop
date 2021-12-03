package ua.com.alevel.fishing_shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alevel.fishing_shop.dto.cartproducts.response.CartProductsResponse;
import ua.com.alevel.fishing_shop.dto.cartproducts.request.SaveCartProductsRequest;
import ua.com.alevel.fishing_shop.entity.CartProducts;
import ua.com.alevel.fishing_shop.entity.Product;
import ua.com.alevel.fishing_shop.entity.User;
import ua.com.alevel.fishing_shop.exception.CartProductsNotFoundException;
import ua.com.alevel.fishing_shop.exception.ItemIsAlreadyAssignedException;
import ua.com.alevel.fishing_shop.repository.CartProductsRepository;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CartProductsService {

    private final CartProductsRepository cartProductsRepository;
    private final ProductService productService;
    private final UserService userService;

    @Autowired
    public CartProductsService(CartProductsRepository cartProductsRepository, ProductService productService, UserService userService) {
        this.cartProductsRepository = cartProductsRepository;
        this.productService = productService;
        this.userService = userService;
    }

    @Transactional
    public CartProductsResponse createCartProducts(SaveCartProductsRequest saveCartProductsRequest) {
        CartProducts cartProducts = convertSaveCartProductsRequestToCartProducts(saveCartProductsRequest);
        return CartProductsResponse.from(cartProductsRepository.save(cartProducts));
    }

    @Transactional
    public CartProductsResponse findCartProductsByIdForResponse(Integer id) {
        CartProducts cartProducts = cartProductsRepository.findById(id).orElseThrow(()
                -> new CartProductsNotFoundException(id));
        return CartProductsResponse.from(cartProducts);
    }

    @Transactional
    public CartProducts findCartProductsById(Integer id) {
        return cartProductsRepository.findById(id).orElseThrow(()
                -> new CartProductsNotFoundException(id));
    }

    @Transactional
    public List<CartProductsResponse> findAllCarts() {
        List<CartProducts> cartProducts = cartProductsRepository.findAll();
        List<CartProductsResponse> cartProductsResponses = new ArrayList<>();
        for (CartProducts cartProducts1 : cartProducts) {
            cartProductsResponses.add(CartProductsResponse.from(cartProducts1));
        }
        return cartProductsResponses;
    }

    @Transactional
    public CartProductsResponse deleteCartProducts(Integer id) {
        CartProducts cartProducts = findCartProductsById(id);
        cartProductsRepository.delete(cartProducts);
        return CartProductsResponse.from(cartProducts);
    }

    @Transactional
    public CartProductsResponse addProductToCartProducts(Integer cartId, Integer productId) {
        CartProducts cartProducts = findCartProductsById(cartId);
        Product product = productService.findProductById(productId);
        if (Objects.nonNull(product.getCartProducts())) {
            throw new ItemIsAlreadyAssignedException(product.getCartProducts().getId(), productId);
        }
        cartProducts.addProduct(product);
        product.setCartProducts(cartProducts);
        return CartProductsResponse.from(cartProducts);
    }

    @Transactional
    public CartProductsResponse removeProductFromCartProducts(Integer cartId, Integer productId) {
        CartProducts cartProducts = findCartProductsById(cartId);
        Product product = productService.findProductById(productId);
        cartProducts.removeProduct(product);
        return CartProductsResponse.from(cartProducts);
    }

    public CartProducts convertSaveCartProductsRequestToCartProducts(SaveCartProductsRequest saveCartProductsRequest) {
        User user = userService.findUserByName(saveCartProductsRequest.getUserName());
        CartProducts cartProducts = new CartProducts();
        cartProducts.setUser(user);
        cartProducts.setCreatedAt(OffsetDateTime.now());
        return cartProducts;
    }


}
