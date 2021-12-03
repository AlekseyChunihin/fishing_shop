package ua.com.alevel.fishing_shop.exception;

public class UserWithSuchIdNotFoundException extends RuntimeException {

    public UserWithSuchIdNotFoundException(Integer id) {
        super("The user with the specified name = " + id + "  does not exist!");
    }
}
