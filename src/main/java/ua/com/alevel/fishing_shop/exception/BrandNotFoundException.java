package ua.com.alevel.fishing_shop.exception;

public class BrandNotFoundException extends RuntimeException {

    public BrandNotFoundException(String name) {
        super("The brand with the specified id = " + name + "  does not exist!");
    }
}
