package DataAccess;

import Dao.DepartmentDao;
import Model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@Repository
public class DepartmentDataAccess implements DepartmentDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DepartmentDataAccess(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Department> getAllDepartments() {
        final String sql = "{CALL catalog_get_departments()}";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            int id = Integer.valueOf(resultSet.getString("department_id"));
            String name = resultSet.getString("name");
            String desc = resultSet.getString("description");
            return new Department(id, name, desc);
        });
    }

    @Override
    public Department getDepartment(int id) {
        final String sql = "{CALL catalog_get_department_details(?)}";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, i) -> {
           String name = resultSet.getString("name");
           String desc = resultSet.getString("description");
           return new Department(id, name, desc);
        });
    }
}
