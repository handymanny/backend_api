package Model;

public class ShippingRegion {

    private int id;
    private String region;

    public ShippingRegion(int id, String region) {
        this.id = id;
        this.region = region;
    }

    public ShippingRegion(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
