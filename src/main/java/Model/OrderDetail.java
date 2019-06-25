package Model;

public class OrderDetail {

    private int itemId;
    private int orderId;
    private int productId;
    private String attributes;
    private String productName;
    private int quantity;
    private double unitCost;
    private double subTotal;

    public OrderDetail(int itemId, int orderId, int productId, String attributes, String productName, int quantity, double unitCost) {
        this.itemId = itemId;
        this.orderId = orderId;
        this.productId = productId;
        this.attributes = attributes;
        this.productName = productName;
        this.quantity = quantity;
        this.unitCost = unitCost;
    }

    public OrderDetail(int orderId, int productId, String attributes, String productName, int quantity, double unitCost, double subTotal) {
        this.orderId = orderId;
        this.productId = productId;
        this.attributes = attributes;
        this.productName = productName;
        this.quantity = quantity;
        this.unitCost = unitCost;
        this.subTotal = subTotal;
    }

    public OrderDetail() {}

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "itemId=" + itemId +
                ", orderId=" + orderId +
                ", productId=" + productId +
                ", attributes='" + attributes + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", unitCost=" + unitCost +
                '}';
    }
}
