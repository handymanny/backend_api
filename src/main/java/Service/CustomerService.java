package Service;

import Dao.CustomerDao;
import Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CustomerService {

    private final CustomerDao customerDao;

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

    public Customer registerCustomer(String name, String email, String password) {
        customerDao.registerCustomer(name, email, password);
        return loginCustomer(email, password);
    }

    public Customer loginCustomer (String email, String password) {
        HashMap<String, String> creds = customerDao.getCustomerLoginInfo(email);
        return getCustomer(Integer.valueOf(creds.get("customer_id")));
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

}
