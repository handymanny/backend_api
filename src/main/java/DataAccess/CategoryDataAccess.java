package DataAccess;


import Dao.CategoryDao;
import Model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDataAccess implements CategoryDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CategoryDataAccess(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Category> getAllCategories(String order, int page, int limit) {
        final String sql = "{CALL catalog_get_categories()}";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            int categoryId = Integer.valueOf(resultSet.getString("category_id"));
            int departmentId = Integer.valueOf(resultSet.getString("department_id"));
            String name = resultSet.getString("name");
            return new Category(categoryId, departmentId, name, "");
        });
    }

    @Override
    public Category getCategoriesById(int id) {
        final String sql = "{CALL catalog_get_category_details(?)}";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, i) -> {
            String name = resultSet.getString("name");
            String desc = resultSet.getString("description");
            int departmentId = Integer.valueOf(resultSet.getString("department_id"));
            return new Category(id, departmentId, name, desc);
        });
    }

    @Override
    public List<Category> getCategoriesOfProduct(int productId) {
        final String sql = "{CALL catalog_get_categories_for_produc(?)}";
        return jdbcTemplate.query(sql, new Object[]{productId}, (resultSet, i) -> {
            int categoryId = Integer.valueOf(resultSet.getString("category_id"));
            int departmentId = Integer.valueOf(resultSet.getString("department_id"));
            String name = resultSet.getString("name");
            return new Category(categoryId, departmentId, name, "");
        });
    }

    @Override
    public List<Category> getCategoriesOfDepartment(int departmentId) {
        final String sql = "{CALL catalog_get_department_categories(?)}";
        return jdbcTemplate.query(sql, new Object[]{departmentId}, (resultSet, i) -> {
            int categoryId = Integer.valueOf(resultSet.getString("category_id"));
            String name = resultSet.getString("name");
            String desc = resultSet.getString("description");
            return new Category(categoryId, departmentId, name, desc);
        });
    }

    @Override
    public Integer getCategoryCount() {
        final String sql = "{CALL catalog_count_categories_on_catalog()}";
        return jdbcTemplate.queryForObject(sql, (resultSet, i) -> Integer.valueOf(resultSet.getString("categories_on_catalog_count")));
    }
}
