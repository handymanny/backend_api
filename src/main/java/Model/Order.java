package Model;

import java.sql.Timestamp;

public class Order {

    private int id;
    private double totalAmount;
    private Timestamp createdOn;
    private Timestamp shippedOn;
    private int status;
    private String comments;
    private int customerId;
    private String authCode;
    private String reference;
    private int shippingId;
    private int taxId;

    public Order(int id, double totalAmount, Timestamp createdOn, Timestamp shippedOn, int status, String comments, int customerId, String authCode, String reference, int shippingId, int taxId) {
        this.id = id;
        this.totalAmount = totalAmount;
        this.createdOn = createdOn;
        this.shippedOn = shippedOn;
        this.status = status;
        this.comments = comments;
        this.customerId = customerId;
        this.authCode = authCode;
        this.reference = reference;
        this.shippingId = shippingId;
        this.taxId = taxId;
    }

    public Order(int id, double totalAmount, Timestamp createdOn, Timestamp shippedOn, int status, String comments) {
        this.id = id;
        this.totalAmount = totalAmount;
        this.createdOn = createdOn;
        this.shippedOn = shippedOn;
        this.status = status;
        this.comments = comments;
    }

    public Order() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    public Timestamp getShippedOn() {
        return shippedOn;
    }

    public void setShippedOn(Timestamp shippedOn) {
        this.shippedOn = shippedOn;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public int getShippingId() {
        return shippingId;
    }

    public void setShippingId(int shippingId) {
        this.shippingId = shippingId;
    }

    public int getTaxId() {
        return taxId;
    }

    public void setTaxId(int taxId) {
        this.taxId = taxId;
    }


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", totalAmount=" + totalAmount +
                ", createdOn=" + createdOn +
                ", shippedOn=" + shippedOn +
                ", status=" + status +
                ", comments='" + comments + '\'' +
                ", customerId=" + customerId +
                ", authCode='" + authCode + '\'' +
                ", reference='" + reference + '\'' +
                ", shippingId=" + shippingId +
                ", taxId=" + taxId +
                '}';
    }
}
