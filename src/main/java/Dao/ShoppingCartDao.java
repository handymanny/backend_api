package Dao;

import Model.CartProduct;

import java.util.HashMap;
import java.util.List;

public interface ShoppingCartDao {

    void addProduct(String cartId, int productId, String attributes);

    List<CartProduct> getProducts(String cartId);

    void updateCartItem(int itemId, int quantity);

    void emptyCart (String cartId);

    void moveToCart (String itemId);

    Integer getTotalAmount(String cartId);

    void saveProductForLater(int itemId);

    HashMap<String, String> getSavedProducts(String cartId);

    void removeProductFromCart (int itemId);

    String getCartId(int itemId);

}
