package Model;

import java.sql.Timestamp;

public class Review {

    private int reviewId;
    private int customerId;
    private int productId;
    private String customerName;
    private String review;
    private short rating;
    private Timestamp createdOn;

    public Review(int reviewId, int customerId, int productId, String customerName, String review, short rating, Timestamp createdOn) {
        this.reviewId = reviewId;
        this.customerId = customerId;
        this.productId = productId;
        this.customerName = customerName;
        this.review = review;
        this.rating = rating;
        this.createdOn = createdOn;
    }

    public Review(String customerName, String review, short rating, Timestamp createdOn) {
        this.customerName = customerName;
        this.review = review;
        this.rating = rating;
        this.createdOn = createdOn;
    }

    public Review() {}

    public int getReviewId() {
        return reviewId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public short getRating() {
        return rating;
    }

    public void setRating(short rating) {
        this.rating = rating;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }
}
