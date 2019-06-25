package DataAccess;

import Dao.ShippingDao;
import Model.ShippingRegion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class ShippingDataAccess implements ShippingDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ShippingDataAccess(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<ShippingRegion> gerShippingRegions() {
        final String sql = "{CALL customer_get_shipping_regions()}";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
           int regionId = Integer.valueOf(resultSet.getString("shipping_region_id"));
           String region = resultSet.getString("shipping_region");
           return new ShippingRegion(regionId, region);
        });
    }

    @Override
    public HashMap<String, String> getShippingRegion(int shippingRegionId) {
        final String sql = "{CALL orders_get_shipping_info(?)}";
        return jdbcTemplate.queryForObject(sql, new Object[]{shippingRegionId}, (resultSet, i) -> {
            HashMap<String, String> map = new HashMap<>();
            map.put("shipping_id", resultSet.getString("shipping_id"));
            map.put("shipping_type", resultSet.getString("shipping_type"));
            map.put("shipping_cost", resultSet.getString("shipping_cost"));
            map.put("shipping_region_id", resultSet.getString("shipping_region_id"));
            return map;
        });
    }
}
