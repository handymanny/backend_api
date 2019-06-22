package DataAccess;

import Dao.AttributeDao;
import Model.Attribute;
import Model.AttributeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AttributeDataAccess implements AttributeDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AttributeDataAccess(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Attribute> getAllAttributes() {
        final String sql = "{CALL catalog_get_attributes()}";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            int id = Integer.valueOf(resultSet.getString("attribute_id"));
            String name = resultSet.getString("name");
            return new Attribute(id, name);
        });
    }

    @Override
    public Attribute getAttribute(int id) {
        final String sql = "{CALL catalog_get_attribute_details(?)}";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, i) -> {
            int attributeId = Integer.valueOf(resultSet.getString("attribute_id"));
            String name = resultSet.getString("name");
            return new Attribute(attributeId, name);
        });
    }

    @Override
    public List<AttributeValue> getAttributeValues(int id) {
        final String sql = "{CALL catalog_get_attribute_values(?)}";
        return jdbcTemplate.query(sql, new Object[]{id}, (resultSet, i) -> {
            int attributeValueId = Integer.valueOf(resultSet.getString("attribute_value_id"));
            int attributeId = Integer.valueOf(resultSet.getString("attribute_id"));
            String value = resultSet.getString("value");
            return new AttributeValue(attributeValueId, attributeId, value);
        });
    }

    @Override
    public List<AttributeValue> getProductAttributes(int productId) {
        final String sql = "{CALL catalog_get_product_attributes(?)}";
        return jdbcTemplate.query(sql, new Object[]{productId}, (resultSet, i) -> {
            int attributeValueId = Integer.valueOf(resultSet.getString("attribute_value_id"));
            int attributeId = Integer.valueOf(resultSet.getString("attribute_id"));
            String value = resultSet.getString("value");
            return new AttributeValue(attributeValueId, attributeId, value);
        });
    }
}
