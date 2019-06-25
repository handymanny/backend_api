package Controller;

import Model.CartProduct;
import Model.Product;
import Service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/shoppingcart")
public class ShoppingCartController {

    private ShoppingCartService shoppingCartService;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @RequestMapping(value = "/generateUniqueId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String createUniqueCartId() {
        return shoppingCartService.createUniqueCartId();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CartProduct> addProduct(@RequestParam("cart_id") String cartId,
                                        @RequestParam("product_id") Integer productId,
                                        @RequestParam("attributes") String attributes) {
        return shoppingCartService.addProduct(cartId, productId, attributes);
    }

    @RequestMapping(value = "/{cart_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CartProduct> getProducts(@PathVariable("cart_id") String cartId) {
        return shoppingCartService.getProducts(cartId);
    }

    @RequestMapping(value = "/update/{item_id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CartProduct> updateCartItem(@PathVariable("item_id") Integer itemId,
                                        @RequestParam("quantity") Integer quantity) {
        return shoppingCartService.updateCartItem(itemId, quantity);
    }

    @RequestMapping(value = "/empty/{cart_id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CartProduct> emptyCart (@PathVariable("cart_id") String cartId) {
        return shoppingCartService.emptyCart(cartId);
    }

    @RequestMapping(value = "/moveToCart/{item_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public void moveToCart (@PathVariable("item_id") String itemId) {
        shoppingCartService.moveToCart(itemId);
    }

    @RequestMapping(value = "/totalAmount/{cart_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer getTotalAmount(@PathVariable("cart_id") String cartId) {
        return shoppingCartService.getTotalAmount(cartId);
    }

    @RequestMapping(value = "/saveForLater/{item_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public void saveProductForLater(@PathVariable("item_id") Integer itemId) {
        shoppingCartService.saveProductForLater(itemId);
    }

    @RequestMapping(value = "/getSaved/{cart_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public HashMap<String, String> getSavedProducts(@PathVariable("cart_id") String cardId) {
        return shoppingCartService.getSavedProducts(cardId);
    }

    @RequestMapping(value = "/removeProduct/{item_id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void removeProductFromCart (@PathVariable("item_id") Integer itemId) {
        shoppingCartService.removeProductFromCart(itemId);
    }

}
