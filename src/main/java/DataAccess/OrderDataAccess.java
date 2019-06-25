package DataAccess;

import Dao.OrderDao;
import Model.Order;
import Model.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class OrderDataAccess implements OrderDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public OrderDataAccess(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Integer createOrder(int customerId, String cartId, int shippingId, int taxId) {
        final String sql = "{CALL shopping_cart_create_order(?, ?, ?, ?)}";
        return jdbcTemplate.queryForObject(sql, new Object[]{customerId, cartId, shippingId, taxId},
                (resultSet, i) -> Integer.valueOf(resultSet.getString("order_id")));
    }

    @Override
    public OrderDetail getOrderInformation(int orderId) {
        final String sql = "{CALL orders_get_order_details(?)}";
        return jdbcTemplate.queryForObject(sql, new Object[]{orderId}, (resultSet, i) -> {
           Integer orderId_t = Integer.valueOf(resultSet.getString("order_id"));
           int productId = Integer.valueOf(resultSet.getString("product_id"));
           String attributes = resultSet.getString("attributes");
           String productName = resultSet.getString("product_name");
           int quantity = Integer.valueOf(resultSet.getString("quantity"));
           double unitCost = Double.valueOf(resultSet.getString("unit_cost"));
           double subTotal = Double.valueOf(resultSet.getString("subtotal"));
           return new OrderDetail(orderId, productId, attributes, productName, quantity, unitCost, subTotal);
        });
    }

    @Override
    public List<Order> getOrdersByCustomer(int customerId) {
        final String sql = "{CALL orders_get_by_customer_id(?)}";
        return jdbcTemplate.query(sql, new Object[]{customerId}, (resultSet, i) -> {
            int orderId = Integer.valueOf(resultSet.getString("order_id"));
            double totalAmount = Double.valueOf(resultSet.getString("total_amount"));
            Timestamp createdOn = Timestamp.valueOf(resultSet.getString("created_on"));
            Timestamp shippedOn = Timestamp.valueOf(resultSet.getString("shipped_on"));
            int status = Integer.valueOf(resultSet.getString("status"));
            String comments = resultSet.getString("name");
            return new Order(orderId, totalAmount, createdOn, shippedOn, status, comments);
        });
    }

    @Override
    public Order getShortOrderDetail(int orderId) {
        final String sql = "{CALL orders_get_order_short_details(?)}";
        return jdbcTemplate.queryForObject(sql, new Object[]{orderId}, (resultSet, i) -> {
            int orderId_t = Integer.valueOf(resultSet.getString("order_id"));
            double totalAmount = Double.valueOf(resultSet.getString("total_amount"));
            Timestamp createdOn = Timestamp.valueOf(resultSet.getString("created_on"));
            Timestamp shippedOn = Timestamp.valueOf(resultSet.getString("shipped_on"));
            int status = Integer.valueOf(resultSet.getString("status"));
            String comments = resultSet.getString("name");
            return new Order(orderId, totalAmount, createdOn, shippedOn, status, comments);
        });
    }
}
