package DataAccess;

import Dao.CustomerDao;
import Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class CustomerDataAccess implements CustomerDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CustomerDataAccess(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void updateCustomer(int customerId, String name, String email, String password, String dayPhone, String evePhone, String mobPhone) {
        final String sql = "{CALL customer_update_account(?, ?, ?, ?, ?, ?, ?)}";
        jdbcTemplate.update(sql, new Object[]{customerId, name, email, password, dayPhone, evePhone, mobPhone});
    }

    @Override
    public Customer getCustomer(int customerId) {
        final String sql = "{CALL customer_get_customer(?)}";
        return jdbcTemplate.queryForObject(sql, new Object[]{customerId}, (resultSet, i) -> {
           String name = resultSet.getString("name");
           String email = resultSet.getString("email");
           String password = resultSet.getString("password");
           String creditCard = resultSet.getString("credit_card");
           String addressOne = resultSet.getString("address_1");
           String addressTwo = resultSet.getString("address_2");
           String city = resultSet.getString("city");
           String region = resultSet.getString("region");
           String postalCode = resultSet.getString("postal_code");
           String country = resultSet.getString("country");
           int shippingRegionId = Integer.valueOf(resultSet.getString("shipping_region_id"));
           String dayPhone = resultSet.getString("day_phone");
           String evePhone = resultSet.getString("eve_phone");
           String mobPhone = resultSet.getString("mob_phone");
           return new Customer(customerId, name, email, password, creditCard,
                   addressOne, addressTwo, city, region, postalCode, country, shippingRegionId,
                   dayPhone, evePhone, mobPhone);
        });
    }

    @Override
    public void registerCustomer(String name, String email, String password) {
        final String sql = "{CALL customer_add(?, ?, ?)}";
        jdbcTemplate.update(sql, new Object[]{name, email, password});
    }

    @Override
    public HashMap<String, String> getCustomerLoginInfo (String email) {
        final String sql = "{CALL customer_get_login_info(?)}";
        return jdbcTemplate.queryForObject(sql, new Object[]{email}, (resultSet, i) -> {
           HashMap<String, String> values = new HashMap<>();
           values.put("customer_id", resultSet.getString("customer_id"));
           values.put("password", resultSet.getString("password"));
           return values;
        });
    }


    @Override
    public void updateAddress(int customerId, String addressOne, String addressTwo, String city, String region, String postalCode, String country, int shippingRegionId) {
        final String sql = "{CALL customer_update_address(?, ?, ?, ?, ?, ?, ?, ?)}";
        jdbcTemplate.update(sql, new Object[]{customerId, addressOne, addressTwo, city, region, postalCode, country, shippingRegionId});
    }

    @Override
    public void updateCreditCard(int customerId, String creditCard) {
        final String sql = "{CALL customer_update_credit_card(?, ?)}";
        jdbcTemplate.update(sql, new Object[]{customerId, creditCard});
    }
}
