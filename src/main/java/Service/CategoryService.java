package Service;

import Dao.CategoryDao;
import Model.Category;
import Model.Product;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private CategoryDao categoryDao;

    @Autowired
    public CategoryService(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public String getAllCategories(String order, int page, int limit) {
        page = page -1;
        if (page > 0) {page = (page * limit);}

        List<Category> categories = categoryDao.getAllCategories(order, page, limit);
        Integer count = getCategoryCount();

        return convertObjects(categories, count);
    }

    public Category getCategoriesById(int id) {
        return categoryDao.getCategoriesById(id);
    }

    public List<Category> getCategoriesOfProduct(int productId) {
        return categoryDao.getCategoriesOfProduct(productId);
    }

    public List<Category> getCategoriesOfDepartment(int departmentId) {
        return categoryDao.getCategoriesOfDepartment(departmentId);
    }

    public Integer getCategoryCount() {
        return categoryDao.getCategoryCount();
    }

    // Helper Methods
    private String convertObjects (List<Category> categories, Integer count) {

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.createObjectNode();
        ((ObjectNode) root).put("count", count);
        JsonNode prods = mapper.createArrayNode();

        for (Category p : categories) {
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
