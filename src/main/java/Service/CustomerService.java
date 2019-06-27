package Service;

import Dao.CustomerDao;
import Model.Customer;
import Security.Authenticator;
import Security.JwtToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CustomerService {

    private final CustomerDao customerDao;

    private Authenticator auth = new Authenticator();

    @Autowired
    public CustomerService (CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public Customer updateCustomer (int customerId, String name, String email, String password, String dayPhone, String evePhone, String mobPhone) {
        customerDao.updateCustomer(customerId, name, email, password, dayPhone, evePhone, mobPhone);
        return getCustomer(customerId);
    }

    public Customer getCustomer (int id) {
        return customerDao.getCustomer(id);
    }

    public String registerCustomer(String name, String email, String password) {
        customerDao.registerCustomer(name, email, password);
        return loginCustomer(email, password);
    }

    public String loginCustomer (String email, String password) {
        // HashMap of our credentials
        HashMap<String, String> creds = customerDao.getCustomerLoginInfo(email);

        // Get token and customer
        JwtToken token = auth.authenticate(email, password);
        Customer tempCustomer = getCustomer(Integer.valueOf(creds.get("customer_id")));

        // Return authenticated customer
        if (token != null && tempCustomer != null) {
            return createCustomerSchema(tempCustomer, token.getToken(), token.getExpire().toString());
        }

        return null;
    }

    public Customer loginFacebookCustomer (String token) {
        return new Customer();
    }

    public Customer updateCustomerAddress (int customerId, String addressOne, String addressTwo, String city, String region, String postalCode, String country, int shippingRegionId) {
        customerDao.updateAddress(customerId, addressOne, addressTwo, city, region, postalCode, country, shippingRegionId);
        return getCustomer(customerId);
    }

    public Customer updateCreditCard (int customerId, String creditCard) {
        customerDao.updateCreditCard(customerId, creditCard);
        return getCustomer(customerId);
    }

    // Helper Method
    private String createCustomerSchema(Customer customer, String token, String expire) {

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.createObjectNode();
        JsonNode customerNode = mapper.createObjectNode();

        ((ObjectNode) customerNode).putPOJO("schema", customer);
        ((ObjectNode) root).set("customer", customerNode);

        ((ObjectNode) root).put("accessToken", "");
        ((ObjectNode) root).put("expires_in", "");

        try {
            return mapper.writeValueAsString(root);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }



}
