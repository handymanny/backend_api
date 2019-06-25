package Model;

public class CartProduct {

    private int itemCartId;
    private String name;
    private String attributes;
    private int productId;
    private double price;
    private int quantity;
    private String image;
    private double subtotal;

    public CartProduct(int itemCartId, String name, String attributes, int productId, double price, int quantity, String image, double subtotal) {
        this.itemCartId = itemCartId;
        this.name = name;
        this.attributes = attributes;
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
        this.subtotal = subtotal;
    }

    public CartProduct(){}

    public int getItemCartId() {
        return itemCartId;
    }

    public void setItemCartId(int itemCartId) {
        this.itemCartId = itemCartId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
