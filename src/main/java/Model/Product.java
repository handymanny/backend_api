package Model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product {

    private int id;
    private String name;
    private String description;
    private double price;
    private double discountedPrice;
    private String image;
    private String imageTwo;
    private String thumbnail;
    private short display;

    public Product(int id, String name, String description, double price, double discountedPrice, String image, String imageTwo, String thumbnail, short display) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.discountedPrice = discountedPrice;
        this.image = image;
        this.imageTwo = imageTwo;
        this.thumbnail = thumbnail;
        this.display = display;
    }

    public Product(int id, String name, String description, double price, double discountedPrice, String thumbnail) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.discountedPrice = discountedPrice;
        this.thumbnail = thumbnail;
    }

    public Product(int id, String name, String description, double price, double discountedPrice, String image, String imageTwo) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.discountedPrice = discountedPrice;
        this.image = image;
        this.imageTwo = imageTwo;
    }

    public Product() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageTwo() {
        return imageTwo;
    }

    public void setImageTwo(String imageTwo) {
        this.imageTwo = imageTwo;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public short getDisplay() {
        return display;
    }

    public void setDisplay(short display) {
        this.display = display;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", discountedPrice=" + discountedPrice +
                ", image='" + image + '\'' +
                ", imageTwo='" + imageTwo + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", display=" + display +
                '}';
    }
}
