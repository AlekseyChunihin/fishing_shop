package ua.com.alevel.fishing_shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.com.alevel.fishing_shop.service.CartProductsService;

@RestController
public class CartProductsController {

    @Autowired
    CartProductsService cartProductsService;

    @GetMapping("/cart")
    public void getCartProducts(){

    }
}