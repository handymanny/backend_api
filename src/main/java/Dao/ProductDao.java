package Dao;

import Model.Product;
import Model.ProductLocation;
import Model.Review;

import java.util.List;

public interface ProductDao {

    List<Product> getAllProducts(int page, int limit, int descLength);

    List<Product> searchProducts(String query, String allWords, int page, int limit, int descLength);

    Product getProduct(int id);

    List<Product> getProductsInCategory(int categoryId, int page, int limit, int descLength);

    List<Product> getProductsInDepartment(int departmentId, int page, int limit, int descLength);

    Product getProductDetails(int id);

    ProductLocation getProductLocations(int id);

    List<Review> getProductReview(int id);

    void postProductReview(int customerId, int productId, String review, short rating);

    Integer getProductCount();
}
