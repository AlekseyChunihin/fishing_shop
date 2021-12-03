package ua.com.alevel.fishing_shop.exception;

public class ItemIsAlreadyAssignedException extends RuntimeException {
    public ItemIsAlreadyAssignedException(Integer cartId, Integer productId) {
        super("The product with the specified id = " + productId + "  is already assigned by another user! with cart " + cartId);
    }
}
