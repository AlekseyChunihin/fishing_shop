package ua.com.alevel.fishing_shop.exception;

public class CartProductsNotFoundException extends RuntimeException {

    public CartProductsNotFoundException(Integer id) {
        super("The cart with the specified id = " + id + "  does not exist!");
    }
}
