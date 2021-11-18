package ua.com.alevel.fishing_shop;

public class Routes {

    public static final String API_ROOT = "/fishingshop";

    public static final String USERS = API_ROOT + "/users";

    public static final String PRODUCTS = API_ROOT + "/products";

    public static final String SHOPPING_CART = API_ROOT + "/cart";

    public static String user(long id) {
        return USERS + '/' + id;
    }

    public static String product(int id) {
        return PRODUCTS + '/' + id;
    }
}
