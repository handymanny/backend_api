package Model;

public class Tax {

    private int id;
    private String taxType;
    private double taxPercentage;

    public Tax(int id, String taxType, double taxPercentage) {
        this.id = id;
        this.taxType = taxType;
        this.taxPercentage = taxPercentage;
    }

    public Tax() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaxType() {
        return taxType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    public double getTaxPercentage() {
        return taxPercentage;
    }

    public void setTaxPercentage(double taxPercentage) {
        this.taxPercentage = taxPercentage;
    }
}
