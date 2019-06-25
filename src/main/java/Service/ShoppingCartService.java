package Service;

import Dao.ShoppingCartDao;
import Model.CartProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class ShoppingCartService {

    private final ShoppingCartDao shoppingCartDao;

    @Autowired
    public ShoppingCartService(ShoppingCartDao shoppingCartDao) {
        this.shoppingCartDao = shoppingCartDao;
    }

    public String createUniqueCartId() {
        return randString(16);
    }

    public List<CartProduct> addProduct(String cartId, int productId, String attributes) {
        shoppingCartDao.addProduct(cartId, productId, attributes);
        return getProducts(cartId);
    }

    public List<CartProduct> getProducts(String cartId) {
        return shoppingCartDao.getProducts(cartId);
    }

    public List<CartProduct> updateCartItem(int itemId, int quantity) {
        shoppingCartDao.updateCartItem(itemId, quantity);
        String cart = getCartId(itemId);

        return getProducts(cart);
    }

    public List<CartProduct> emptyCart (String cartId) {
        shoppingCartDao.emptyCart(cartId);
        return getProducts(cartId);
    }

    public void moveToCart (String itemId) {
        shoppingCartDao.moveToCart(itemId);
    }

    public Integer getTotalAmount(String cartId) {
        return shoppingCartDao.getTotalAmount(cartId);
    }

    public void saveProductForLater(int itemId) {
        shoppingCartDao.saveProductForLater(itemId);
    }

    public HashMap<String, String> getSavedProducts(String cardId) {
        return shoppingCartDao.getSavedProducts(cardId);
    }

    public void removeProductFromCart (int itemId) {
        shoppingCartDao.removeProductFromCart(itemId);
    }

    private String getCartId(int itemId) {
        return shoppingCartDao.getCartId(itemId);
    }
    
    //Helper Methods
    private String randString(int length) {
        return UUID.randomUUID().toString().replace("-", "").substring(0, Math.min(length, 32)) + (length > 32 ? randString(length - 32) : "");
    }
}
