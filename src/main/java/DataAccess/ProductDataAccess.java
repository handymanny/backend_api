package DataAccess;

import Dao.ProductDao;
import Model.Product;
import Model.ProductLocation;
import Model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class ProductDataAccess implements ProductDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductDataAccess(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Product> getAllProducts(int page, int limit, int descLength) {
        final String sql = "{CALL catalog_get_products_on_catalog(?, ?, ?)}";
        return jdbcTemplate.query(sql, new Object[]{descLength, limit, page}, (resultSet, i) -> {
            int productId = Integer.valueOf(resultSet.getString("product_id"));
            String name = resultSet.getString("name");
            String description = resultSet.getString("description");
            double price = Double.valueOf(resultSet.getString("price"));
            double discountedPrice = Double.valueOf(resultSet.getString("discounted_price"));
            String thumbnail = resultSet.getString("thumbnail");
           return new Product(productId, name, description, price, discountedPrice, thumbnail);
        });
    }
    //WHERE    display = 1 OR display = 3\r\n
    @Override
    public List<Product> searchProducts(String query, String allWords, int page, int limit, int descLength) {
        final String sql = "{CALL catalog_search(?, ?, ?, ?, ?)}";
        return jdbcTemplate.query(sql, new Object[]{query, allWords, descLength, limit, page}, (resultSet, i) -> {
            int productId = Integer.valueOf(resultSet.getString("product_id"));
            String name = resultSet.getString("name");
            String description = resultSet.getString("description");
            double price = Double.valueOf(resultSet.getString("price"));
            double discountedPrice = Double.valueOf(resultSet.getString("discounted_price"));
            String thumbnail = resultSet.getString("thumbnail");
            return new Product(productId, name, description, price, discountedPrice, thumbnail);
        });
    }

    @Override
    public Product getProduct(int id) {
        final String sql = "{CALL catalog_get_product_info(?)}";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, i) -> {
            int productId = Integer.valueOf(resultSet.getString("product_id"));
            String name = resultSet.getString("name");
            String description = resultSet.getString("description");
            double price = Double.valueOf(resultSet.getString("price"));
            double discountedPrice = Double.valueOf(resultSet.getString("discounted_price"));
            String image = resultSet.getString("image");
            String imageTwo = resultSet.getString("image_2");
            String thumbnail = resultSet.getString("thumbnail");
            short display = Short.valueOf(resultSet.getString("display"));
            return new Product(productId, name, description, price, discountedPrice, image, imageTwo, thumbnail, display);
        });
    }

    @Override
    public List<Product> getProductsInCategory(int categoryId, int page, int limit, int descLength) {
        final String sql = "{CALL catalog_get_products_in_category(?, ?, ?, ?)}";
        return jdbcTemplate.query(sql, new Object[]{categoryId, descLength, limit, page}, (resultSet, i) -> {
            int productId = Integer.valueOf(resultSet.getString("product_id"));
            String name = resultSet.getString("name");
            String description = resultSet.getString("description");
            double price = Double.valueOf(resultSet.getString("price"));
            double discountedPrice = Double.valueOf(resultSet.getString("discounted_price"));
            String thumbnail = resultSet.getString("thumbnail");
            return new Product(productId, name, description, price, discountedPrice, thumbnail);
        });
    }

    @Override
    public List<Product> getProductsInDepartment(int departmentId, int page, int limit, int descLength) {
        final String sql = "{CALL catalog_get_products_on_department(?, ?, ?, ?)}";
        return jdbcTemplate.query(sql, new Object[]{departmentId, descLength, limit, page}, (resultSet, i) -> {
            int productId = Integer.valueOf(resultSet.getString("product_id"));
            String name = resultSet.getString("name");
            String description = resultSet.getString("description");
            double price = Double.valueOf(resultSet.getString("price"));
            double discountedPrice = Double.valueOf(resultSet.getString("discounted_price"));
            String thumbnail = resultSet.getString("thumbnail");
            return new Product(productId, name, description, price, discountedPrice, thumbnail);
        });
    }

    @Override
    public Product getProductDetails(int id) {
        final String sql = "{CALL catalog_get_product_details(?)}";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, i) -> {
            int productId = Integer.valueOf(resultSet.getString("product_id"));
            String name = resultSet.getString("name");
            String description = resultSet.getString("description");
            double price = Double.valueOf(resultSet.getString("price"));
            double discountedPrice = Double.valueOf(resultSet.getString("discounted_price"));
            String image = resultSet.getString("image");
            String imageTwo = resultSet.getString("image_2");
            return new Product(productId, name, description, price, discountedPrice, image, imageTwo);
        });
    }

    @Override
    public ProductLocation getProductLocations(int id) {
        final String sql = "{CALL catalog_get_product_locations(?)}";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, i) -> {
            int categoryId = Integer.valueOf(resultSet.getString("category_id"));
            String categoryName = resultSet.getString("category_name");
            int departmentId = Integer.valueOf(resultSet.getString("department_id"));
            String departmentName = resultSet.getString("department_name");
            return new ProductLocation(categoryId, departmentId, categoryName, departmentName);
        });
    }

    @Override
    public List<Review> getProductReview(int id) {
        final String sql = "{CALL catalog_get_product_reviews(?)}";
        return jdbcTemplate.query(sql, new Object[]{id}, (resultSet, i) -> {
            String name = resultSet.getString("");
            String review = resultSet.getString("");
            short rating = Short.valueOf(resultSet.getString(""));
            Timestamp createdOn = Timestamp.valueOf(resultSet.getString(""));
            return new Review(name, review, rating, createdOn);
        });
    }

    @Override
    public void postProductReview(int customerId, int productId, String review, short rating) {
        final String sql = "{CALL catalog_create_product_review(?, ?, ?, ?)}";
        jdbcTemplate.update(sql, customerId, productId, review, rating);
    }

    @Override
    public Integer getProductCount() {
        final String sql = "{CALL catalog_count_products_on_catalog()}";
        return jdbcTemplate.queryForObject(sql, (resultSet, i) -> Integer.valueOf(resultSet.getString("products_on_catalog_count")));
    }
}
