package Service;

import Dao.ProductDao;
import Model.Product;
import Model.ProductLocation;
import Model.Review;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ProductService {

    private ProductDao productDao;

    @Autowired
    public ProductService( ProductDao productDao) {
        this.productDao = productDao;
    }

    public String getAllProducts(int page, int limit, int descLength) {
        page = page -1;
        if (page > 0) {page = (page * limit);}

        List<Product> products = productDao.getAllProducts(page, limit, descLength);
        Integer count = getProductCount();
        return convertObjects(products, count);
    }

    public List<Product> searchProducts(String query, String allWords, int page, int limit, int descLength) {
        page = page -1;
        if (page > 0) {page = (page * limit);}
        return  productDao.searchProducts(query, allWords, page, limit, descLength);
    }

    public Product getProduct(int id) {
        return productDao.getProduct(id);
    }

    public List<Product> getProductsInCategory(int categoryId, int page, int limit, int descLength) {
        page = page -1;
        if (page > 0) {page = (page * limit);}
        return productDao.getProductsInCategory(categoryId, page, limit, descLength);
    }

    public List<Product> getProductsInDepartment(int departmentId, int page, int limit, int descLength) {
        page = page -1;
        if (page > 0) {page = (page * limit);}
        return productDao.getProductsInDepartment(departmentId, page, limit, descLength);
    }

    public Product getProductDetails(int id) {
        return productDao.getProductDetails(id);
    }

    public ProductLocation getProductLocations(int id) {
        return productDao.getProductLocations(id);
    }

    public List<Review> getProductReview(int id) {
        return productDao.getProductReview(id);
    }

    public void postProductReview(int customerId, int productId, String review, short rating) {
        productDao.postProductReview(customerId, productId, review, rating);
    }

    public Integer getProductCount() {
        return productDao.getProductCount();
    }


    private String convertObjects (List<Product> products, Integer count) {

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.createObjectNode();
        ((ObjectNode) root).put("count", count);
        JsonNode prods = mapper.createArrayNode();

        for (Product p : products) {
            ((ArrayNode) prods).addPOJO(p);
        }

        ((ObjectNode) root).set("rows", prods);

        try {
            return mapper.writeValueAsString(root);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
