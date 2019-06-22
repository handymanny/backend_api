package Dao;

import Model.Category;

import java.util.List;

public interface CategoryDao {

    List<Category> getAllCategories(String order, int page, int limit);

    Category getCategoriesById(int id);

    List<Category> getCategoriesOfProduct(int productId);

    List<Category> getCategoriesOfDepartment(int departmentId);

    Integer getCategoryCount();
}
