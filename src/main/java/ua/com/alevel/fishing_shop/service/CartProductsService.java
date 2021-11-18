package ua.com.alevel.fishing_shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import ua.com.alevel.fishing_shop.entity.CartProducts;
import ua.com.alevel.fishing_shop.entity.User;
import ua.com.alevel.fishing_shop.repository.CartProductsRepository;

import java.util.List;

public class CartProductsService {

    @Autowired
    private CartProductsRepository cartProductsRepository;

    public List<CartProducts> listCartProducts(User user) {
        return cartProductsRepository.findByUser(user);
    }
}
