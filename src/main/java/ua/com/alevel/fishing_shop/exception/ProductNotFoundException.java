package ua.com.alevel.fishing_shop.exception;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(Integer id) {
        super("The product with the specified id = "+ id + "  does not exist!");
    }
}
