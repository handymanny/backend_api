package Controller;

import Model.Customer;
import Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/customer", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer updateCustomer (@RequestParam("name") String name,
                                    @RequestParam("email") String email,
                                    @RequestParam(required = false) String password,
                                    @RequestParam(required = false) String dayPhone,
                                    @RequestParam(required = false) String evePhone,
                                    @RequestParam(required = false) String mobPhone) {
        // Test ID before we add security
        int id = 0;

        return customerService.updateCustomer(id, name, email, password, dayPhone, evePhone, mobPhone);
    }

    @RequestMapping(value = "/customer", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer getCustomer (@RequestParam("token") Integer token) {
        return customerService.getCustomer(token);
    }

    @RequestMapping(value = "/customers", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer registerCustomer (@RequestParam("name") String name,
                                      @RequestParam("email") String email,
                                      @RequestParam("password") String password) {

        return customerService.registerCustomer(name, email, password);
    }

    @RequestMapping(value = "/customers/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer loginCustomer (@RequestParam("email") String email,
                                   @RequestParam("password") String password) {

        return customerService.loginCustomer(email, password);
    }

    @RequestMapping(value = "/customers/facebook", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer loginFacebookCustomer (@RequestParam("access_token") String token) {
        return customerService.loginFacebookCustomer(token);
    }

    @RequestMapping(value = "/customers/address", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer updateCustomerAddress (@RequestParam("address_1") String addressOne,
                                           @RequestParam(required = false) String addressTwo,
                                           @RequestParam("city") String city,
                                           @RequestParam("region") String region,
                                           @RequestParam("postal_code") String postalCode,
                                           @RequestParam("country") String country,
                                           @RequestParam("shipping_region_id") Integer shippingRegionId) {

        // Test ID before we add security
        int id = 0;
        return customerService.updateCustomerAddress(id, addressOne, addressTwo, city, region, postalCode, country, shippingRegionId);
    }

    @RequestMapping(value = "/customers/creditCard", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer updateCreditCard (@RequestParam("credit_card") String creditCard) {
        // Test ID before we add security
        int id = 0;
        return customerService.updateCreditCard(id, creditCard);
    }

}
