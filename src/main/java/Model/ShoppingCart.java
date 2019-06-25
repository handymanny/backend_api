package Model;

import java.sql.Timestamp;

public class ShoppingCart {

    private int itemId;
    private char[] cartId;
    private int productId;
    private String attributes;
    private int quantity;
    private short buyNow;
    private Timestamp addedOn;

    public ShoppingCart(int itemId, char[] cartId, int productId, String attributes, int quantity, short buyNow, Timestamp addedOn) {
        this.itemId = itemId;
        this.cartId = cartId;
        this.productId = productId;
        this.attributes = attributes;
        this.quantity = quantity;
        this.buyNow = buyNow;
        this.addedOn = addedOn;
    }

    public ShoppingCart(int itemId, char[] cartId, int productId, String attributes, int quantity) {
        this.itemId = itemId;
        this.cartId = cartId;
        this.productId = productId;
        this.attributes = attributes;
        this.quantity = quantity;
    }

    public ShoppingCart() {}


    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public char[] getCartId() {
        return cartId;
    }

    public void setCartId(char[] cartId) {
        this.cartId = cartId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public short getBuyNow() {
        return buyNow;
    }

    public void setBuyNow(short buyNow) {
        this.buyNow = buyNow;
    }

    public Timestamp getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(Timestamp addedOn) {
        this.addedOn = addedOn;
    }
}
