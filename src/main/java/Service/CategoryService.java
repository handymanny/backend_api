package Service;

import Dao.CategoryDao;
import Model.Category;
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

    public List<Category> getAllCategories(String order, int page, int limit) {
        return categoryDao.getAllCategories(order, page, limit);
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

}
