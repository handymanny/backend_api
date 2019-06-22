package Model;

public class Customer {

    private int customerId;
    private String name;
    private String email;
    private String password;
    private String creditCard;
    private String addressOne;
    private String addressTwo;
    private String city;
    private String region;
    private String postalCode;
    private String country;
    private int shippingRegionId;
    private String dayPhone;
    private String evePhone;
    private String mobPhone;

    public Customer(int customerId, String name, String email, String password, String creditCard, String addressOne, String addressTwo, String city, String region, String postalCode, String country, int shippingRegionId, String dayPhone, String evePhone, String mobPhone) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.creditCard = creditCard;
        this.addressOne = addressOne;
        this.addressTwo = addressTwo;
        this.city = city;
        this.region = region;
        this.postalCode = postalCode;
        this.country = country;
        this.shippingRegionId = shippingRegionId;
        this.dayPhone = dayPhone;
        this.evePhone = evePhone;
        this.mobPhone = mobPhone;
    }

    public Customer() {}

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public String getAddressOne() {
        return addressOne;
    }

    public void setAddressOne(String addressOne) {
        this.addressOne = addressOne;
    }

    public String getAddressTwo() {
        return addressTwo;
    }

    public void setAddressTwo(String addressTwo) {
        this.addressTwo = addressTwo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getShippingRegionId() {
        return shippingRegionId;
    }

    public void setShippingRegionId(int shippingRegionId) {
        this.shippingRegionId = shippingRegionId;
    }

    public String getDayPhone() {
        return dayPhone;
    }

    public void setDayPhone(String dayPhone) {
        this.dayPhone = dayPhone;
    }

    public String getEvePhone() {
        return evePhone;
    }

    public void setEvePhone(String evePhone) {
        this.evePhone = evePhone;
    }

    public String getMobPhone() {
        return mobPhone;
    }

    public void setMobPhone(String mobPhone) {
        this.mobPhone = mobPhone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", creditCard='" + creditCard + '\'' +
                ", addressOne='" + addressOne + '\'' +
                ", addressTwo='" + addressTwo + '\'' +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                ", shippingRegionId=" + shippingRegionId +
                ", dayPhone='" + dayPhone + '\'' +
                ", evePhone='" + evePhone + '\'' +
                ", mobPhone='" + mobPhone + '\'' +
                '}';
    }
}
