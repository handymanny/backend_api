package Dao;

import Model.Customer;

import java.util.HashMap;

public interface CustomerDao {

    // Need authentication token
    void updateCustomer (int customerId, String name, String email, String password, String dayPhone, String evePhone, String mobPhone);

    // Need authentication token
    Customer getCustomer (int customerId);

    // Create authentication token
    void registerCustomer (String name, String email, String password);

    // Create authentication token
    HashMap<String, String> getCustomerLoginInfo (String email);

    // Need authentication token
    void updateAddress (int customerId, String addressOne, String addressTwo, String city, String region, String postalCode, String country, int shippingRegionId);

    // Need authentication token
    void updateCreditCard (int customerId, String creditCard);
}
