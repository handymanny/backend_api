package DataAccess;

import Dao.ShoppingCartDao;
import Model.CartProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class ShoppingCartDataAccess implements ShoppingCartDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ShoppingCartDataAccess(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addProduct(String cartId, int productId, String attributes) {
        final String sql = "{CALL shopping_cart_add_product(?, ?, ?)}";
        jdbcTemplate.update(sql, cartId, productId, attributes);
    }

    @Override
    public List<CartProduct> getProducts(String cartId) {
        final String sql = "{CALL shopping_cart_get_products(?)}";
        return jdbcTemplate.query(sql, new Object[]{cartId}, (resultSet, i) -> {
            int itemId = Integer.valueOf(resultSet.getString("item_id"));
            String name = resultSet.getString("name");
            String attributes = resultSet.getString("attributes");
            double discountedPrice = Double.valueOf(resultSet.getString("price"));
            int quantity = Integer.valueOf(resultSet.getString("quantity"));
            int productId = Integer.valueOf(resultSet.getString("product_id"));
            String image = resultSet.getString("image");
            double subtotal = Double.valueOf(resultSet.getString("subtotal"));
            return new CartProduct(itemId, name, attributes, productId, discountedPrice, quantity, image, subtotal);
        });
    }

    @Override
    public void updateCartItem(int itemId, int quantity) {
        final String sql = "{CALL shopping_cart_update(?, ?)}";
        jdbcTemplate.update(sql, itemId, quantity);
    }

    @Override
    public void emptyCart(String cartId) {
        final String sql = "{CALL shopping_cart_empty(?)}";
        jdbcTemplate.update(sql, cartId);
    }

    @Override
    public void moveToCart(String itemId) {
        final String sql = "{CALL shopping_cart_move_product_to_cart(?)}";
        jdbcTemplate.update(sql,itemId);
    }

    @Override
    public Integer getTotalAmount(String cartId) {
        final String sql = "{CALL shopping_cart_get_total_amount(?)}";
        return jdbcTemplate.queryForObject(sql, new Object[]{cartId},
                (resultSet, i) -> Integer.valueOf("total_amount"));
    }

    @Override
    public void saveProductForLater(int itemId) {
        final String sql = "{CALL shopping_cart_save_product_for_later(?)}";
        jdbcTemplate.update(sql, itemId);
    }

    @Override
    public HashMap<String, String> getSavedProducts(String cartId) {
        final String sql = "{CALL shopping_cart_get_saved_products(?)}";
        return jdbcTemplate.queryForObject(sql, new Object[]{cartId}, (resultSet, i) -> {
            HashMap<String, String> map = new HashMap<>();
            map.put("item_id", resultSet.getString("item_id"));
            map.put("name", resultSet.getString("name"));
            map.put("attributes", resultSet.getString("attributes"));
            map.put("price", resultSet.getString("price"));
            return map;
        });
    }

    @Override
    public void removeProductFromCart(int itemId) {
        final String sql = "{CALL shopping_cart_remove_product(?)}";
        jdbcTemplate.update(sql, itemId);
    }

    @Override
    public String getCartId(int itemId) {
        final String sql = "{CALL shopping_cart_get_cart_from_item(?)}";
        return jdbcTemplate.queryForObject(sql, new Object[]{itemId}, (resultSet, i) -> resultSet.getString("cart_id"));
    }
}
