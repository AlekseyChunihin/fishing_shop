package ua.com.alevel.fishing_shop.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String name) {
        super("The user with the specified name = " + name + "  does not exist!");
    }
}
